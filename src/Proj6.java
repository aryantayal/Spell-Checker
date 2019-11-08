import java.io.IOException;
import java.util.Scanner;
/**
 * This main method runs the other classes
 * This program Checks the spelling for the sentence that is imputed and will keep running until its done.
 *
 * Aryan Tayal
 * Proj6
 * Thursday 2:30
 */
public class Proj6 {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        boolean again = true;
        SpellChecker spelling = new SpellChecker(args[0]);

        do {
            System.out.print("\nEnter a sentence (press enter to quit): ");

            String sentence = s.nextLine();
            if (sentence.equals("")) {

                break;
            }
            String[] words = sentence.split(" ");

            int i = 0;

            for (i = 0; i < words.length; i++) {
                if (spelling.findCorrections(words[i]) == null) {
                    continue;
                } else {
                    System.out.println("I dont have an entry for " + words[i]);
                    System.out.println("Did you mean any of these words?\n");
                    int count = 1;
                    ResizeableArray correction = spelling.findCorrections(words[i]);
                    for (count = 0; count < correction.size(); count++) {
                        System.out.println("(" + (count + 1) + ")" + correction.elemAt(count));

                    }
                    System.out.println("(" + (count + 1) + ")" + "Ignore word");
                    System.out.println("(" + (count + 2) + ")" + "Add to dictionary");
                    System.out.print("Enter the line of the number of correction: ");
                    int choice = s.nextInt();
                    if (choice <= count) {
                        words[i] = (String) correction.elemAt(choice - 1);
                    }
                    if (choice == count + 1) {
                        continue;
                    }
                    if (choice == count + 2) {
                        spelling.addToArray(words[i]);
                    }
                } // end else
            } // end for loop
            System.out.println("Spelled Checked: ");
            for (int j = 0; j < words.length; j++) {

                System.out.print(words[j] + " ");
            }

        }while(again);

        System.out.println("Do you want to update file " + args[0] + " to add your new words (y/n)?");
        char update = s.next().charAt(0);
        if(update == 'y' || update == 'Y'){
            spelling.printFile(args[0]);
        }
    }

}
