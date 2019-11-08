import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellChecker {
    private ResizeableArray array;
    Scanner s = new Scanner(System.in);

    public SpellChecker(String fileName) throws FileNotFoundException {

        array = new ResizeableArray();

        Scanner inFile = new Scanner(new File(fileName));

        while (inFile.hasNext()) {
            array.add(inFile.next().trim());
        }
        inFile.close();
    }

    public int distance (String str1, String str2) {
        int distance, cost, min = 0;
        int n = str1.length();
        int m = str2.length();

        int[][] d = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    cost = 0;
                } else {
                    cost = 1;
                }
                min = d[i][j - 1] + 1;
                if (d[i - 1][j] + 1 < min) {
                    min = d[i - 1][j] + 1;
                }
                if (d[i - 1][j - 1] + cost < min) {
                    min = d[i - 1][j - 1] + cost;
                }
                d[i][j] = min;
            }
        }


        return d[n][m];
    }
    public ResizeableArray findCorrections (String word){
        ResizeableArray correct = new ResizeableArray();

        for(int i = 0; i < array.size(); i++){
            int distance;
            if(word.equals(array.elemAt(i))){
                return null;
            }
            else{
               distance =  distance(word, (String) array.elemAt(i));
               if(distance <(1+ word.length()/5)){
                   correct.add(array.elemAt(i));
               }
            }
        }
        return correct;
        }
        public void addToArray (String newWord){
            array.add(newWord);
        }
}