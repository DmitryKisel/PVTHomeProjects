package kiseld;

import kiseld.entity.Sentence;
import kiseld.entity.Word;

import java.util.List;

public class ChangeTheSymbol extends Change {

    /**
     * This method changes symbol with number k  for the incoming symbol in the word
     * and saves new value of the word.
     * @param
     * @return nothing
     */
    void change(List<Sentence> sentenceList, int k, char value){
        SplitToWords splitToWords = new SplitSentenceToWords();

        for (Sentence sentence: sentenceList){
            splitToWords.splitToWords(sentence);
            for(Word word : sentence.getWordList()){
                if(word.getWordContent().contains("\\p{Punct}") ||
                        word.getWordContent().equals(" ")){
                    continue;
                }
                else {
                    if (word.getWordContent().length() >= k+1) {
                        StringBuilder stringBuilder = new StringBuilder(word.getWordContent());
                        stringBuilder.setCharAt(k, value);
                        word.setWordContent(stringBuilder.toString());
                    }
                }
            }
        }
    }
}
