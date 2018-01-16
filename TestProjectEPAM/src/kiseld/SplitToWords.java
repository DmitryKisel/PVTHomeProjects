package kiseld;

import kiseld.entity.Sentence;
import kiseld.entity.Word;

import java.util.List;

public interface SplitToWords {
    List<Word> splitToWords(Sentence sentence);
}
