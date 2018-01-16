package kiseld;

import kiseld.entity.Sentence;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class SplitTextToSentence implements SplitToSentence {


    /**
     * This method splits incoming text to sentences and put them in to the list
     * @param text
     * @return list of sentences
     */
    @Override
    public List<Sentence> split(String text) {
        List<Sentence> sentenceList = new ArrayList<>();
        BreakIterator bi = BreakIterator.getSentenceInstance();
        bi.setText(text);
        int index = 0;
        while (bi.next() != BreakIterator.DONE) {
            Sentence sentence = new Sentence(text.substring(index, bi.current()));
            sentenceList.add(sentence);
            index = bi.current();
        }
        return sentenceList;
    }
}

