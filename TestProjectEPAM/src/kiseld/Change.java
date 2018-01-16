package kiseld;

import kiseld.entity.Sentence;

import java.util.List;

public abstract class Change {
   abstract void change(List<Sentence> sentenceList, int k, char value);
}
