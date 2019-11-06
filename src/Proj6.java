import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proj6 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a sentence (press enter to quit): ");
        String sentence = s.nextLine();

        String[] words=sentence.split(" ");

        int i = 0;
        String fileName = "lexicon.txt";
        SpellChecker spelling = new SpellChecker(fileName);

        for(i = 0; i < words.length; i++){
            if(spelling.findCorrections(words[i]) == null){
                continue;
            }
            else{
                System.out.println("I dont have an entry for" + words[i]);
                System.out.println("Did you mean any of these words?\n");
                int count =0;
                ResizeableArray correction = spelling.findCorrections(words[i]);
                for(count = 0; count < correction.size(); count ++  ){
                    System.out.println("(" + count + ")" + words[i]);

                }
                System.out.println("(" + (count + 1) + ")" + "Ignore word");
                System.out.println("(" + (count + 2) + ")" + "Add to dictionary");
                System.out.print("Enter the line of the number of correction: ");
                int choice = s.nextInt();
                if(choice <= count){
                    words[i] = (String) correction.elemAt(choice);
                }
                if(choice == count +1){
                    continue;
                }
                if(choice == count + 2){
                    spelling.addToArray(words[i]);
                }
            } // end else
        } // end for loop

    }




}
