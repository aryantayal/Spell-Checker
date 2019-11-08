import java.io.*;
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

        for (int i = 0; i <= str1.length(); i++) {
            d[i][0] = i;
        }
        //initializing the columns
        for (int j = 0; j <= str2.length(); j++) {
            d[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m; j++) {
                if (Character.toLowerCase(str1.charAt(i-1)) == Character.toLowerCase(str2.charAt(j-1))) {
                    cost = 0;
                } else {
                    cost = 1;
                }
                if (d[i][j-1] == 0) {
                    min = 1;
                } else {
                    min = d[i][j - 1] + 1;
                }
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
                if(distance <=(1+ word.length()/5)){
                    correct.add(array.elemAt(i));
                }
            }
        }
        return correct;
    }
    public void addToArray (String newWord){
        array.add(newWord);
    }

    public void printFile( String fileName) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(fileName));
        for(int i = 0; i <array.size(); i++){
            pw.println(array.elemAt(i));
        }
        pw.close();
    }
}
