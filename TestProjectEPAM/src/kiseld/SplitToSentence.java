package kiseld;

import kiseld.entity.Sentence;

import java.util.List;

interface SplitToSentence {
    List<Sentence> split(String text);
}
