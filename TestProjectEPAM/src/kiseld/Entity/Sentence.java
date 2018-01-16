package kiseld.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private String content;
    private List<Word> wordList;

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    public Sentence(String content) {
        this.content = content;
        wordList = new ArrayList<>();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
