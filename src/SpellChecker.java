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
        int[][] d = new int[str1.length()][str2.length()];

        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
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
        distance = d[str1.length() - 1][str2.length() - 1];

        return distance;
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

}