package kiseld.entity;

public class Word {
    private String wordContent;

    public String getWordContent() {
        return wordContent;
    }

    public void setWordContent(String wordContent) {
        this.wordContent = wordContent;
    }

    public Word(String wordContent) {
        this.wordContent = wordContent;
    }
}
