package kiseld;

import kiseld.Entity.Sentence;
import kiseld.Entity.Word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String text = args[0];
        List<Sentence> sentenceList = new ArrayList<>();
        int k = 0;// k - the nomber of the symbol to change
        char value = 0;// value - the value for changing symbol with k number

        SplitToSentence splitToSentence = new SplitTextToSentence();
        sentenceList = splitToSentence.split(text);
        ChangeTheSymbol changeTheSymbol = new ChangeTheSymbol();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isFilled = false;
        do {
            try {
                System.out.println("Введите номер символа для замены");
                String kSymbol = reader.readLine();
                // This pattern allows to avoid inputting incorrect value of k parameter
                String pattern = "^[1-9]\\d*$";
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(kSymbol);

                if (!m.matches()) {
                    System.out.println("Неправильный ввод данных");
                    isFilled = false;

                } else {
                    k = Integer.parseInt(kSymbol) - 1;
                    isFilled = true;
                    break;
                }
            } catch (IOException e) {
                System.out.println("Ошибка ввода данных " + e.toString());
            }
        } while (isFilled = true);

                System.out.println("Введите символ на какой вы бы хотели заменить " +
                        (k + 1) + "-й символ");
        try {
            value = reader.readLine().charAt(0);
        } catch (IOException e) {
            System.out.println("Ошибка ввода данных " + e.toString());
        }

        changeTheSymbol.change(sentenceList, k, value);
        System.out.println(text);
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
