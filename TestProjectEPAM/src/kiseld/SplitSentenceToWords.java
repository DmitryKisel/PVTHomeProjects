package kiseld;

import kiseld.Entity.Sentence;
import kiseld.Entity.Word;

import java.text.BreakIterator;
import java.util.List;

public class SplitSentenceToWords {
    /**
     * This method splits incoming sentence to words and put them in to the list
     * @param text
     * @return list of words
     */
    List<Word> splitToWords(Sentence sentence){
        BreakIterator br = BreakIterator.getWordInstance();
        br.setText(sentence.getContent());
        int index = 0;
        while (br.next() != BreakIterator.DONE) {
            Word word = new Word(sentence.getContent().substring(index, br.current()));
            sentence.getWordList().add(word);
            index = br.current();
        }
        return sentence.getWordList();
    }
}
