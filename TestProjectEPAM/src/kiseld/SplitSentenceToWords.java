package kiseld;

import kiseld.entity.Sentence;
import kiseld.entity.Word;

import java.text.BreakIterator;
import java.util.List;

public class SplitSentenceToWords implements SplitToWords{
    /**
     * This method splits incoming sentence to words and put them in to the list
     * @return list of words
     */
    @Override
    public List<Word> splitToWords(Sentence sentence){
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
