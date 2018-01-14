package kiseld;

import kiseld.Entity.Sentence;

import java.util.List;

interface SplitToSentence {
    List<Sentence> split(String text);
}
