package kiseld;

import kiseld.entity.Sentence;
import kiseld.entity.Word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String kPattern = "^[1-9]\\d*$";
    private static final String valuePattern = ".";

    public static void main(String[] args) {
        int k = 0;// k - the nomber of the symbol to change
        char value = 0;// value - the value for changing symbol with k number

        if (args.length == 0){
            System.out.println("No argument found. Run application with argument");
            System.exit(0);
        }

        SplitToSentence splitToSentence = new SplitTextToSentence();
        List<Sentence> sentenceList = splitToSentence.split(args[0]);
        ChangeTheSymbol changeTheSymbol = new ChangeTheSymbol();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isFilled = false;
        do {
            try {
                System.out.println("Input the symbol number for replace");
                String kSymbol = reader.readLine();
                // This pattern allows to avoid inputting incorrect value of k parameter

                Pattern p = Pattern.compile(kPattern);
                Matcher m = p.matcher(kSymbol);

                if (!m.matches()) {
                    System.out.println("Incorrect input");
                    isFilled = false;

                } else {
                    k = Integer.parseInt(kSymbol) - 1;
                    isFilled = true;
                    break;
                }
            } catch (IOException e) {
                System.out.println("Input error " + e.toString());
            }
        } while (isFilled = true);



        do {
            try {
                isFilled = false;
                System.out.println("Input single symbol for replacing the " +
                        (k + 1) + " symbol in the word");
                String valueString = reader.readLine();
                // This pattern allows to avoid inputting incorrect value of k parameter

                Pattern p = Pattern.compile(valuePattern);
                Matcher m = p.matcher(valueString);

                if (!m.matches()) {
                    System.out.println("Incorrect input");
                    isFilled = false;

                } else {
                    value = valueString.charAt(0);
                    isFilled = true;
                    break;
                }
            } catch (IOException e) {
                System.out.println("Input error " + e.toString());
            }
        } while (isFilled = true);

        changeTheSymbol.change(sentenceList, k, value);
        System.out.println("Original text: ");
        System.out.println(args[0]);
        System.out.println("Text with replaced " + (k + 1) + " symbol in the words: ");
        printChangedText(sentenceList);
    }

    /**
     * This method prints changed text
     * @param sentenceList
     */
    static void printChangedText (List<Sentence> sentenceList){
        for (Sentence sentence :sentenceList) {
            for (Word word : sentence.getWordList()) {
                System.out.print(word.getWordContent());
            }
        }
    }
}
