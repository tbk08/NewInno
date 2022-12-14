package dto;

public class Answer {
    private final String text;

    public Answer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Answer) {
            String s = ((Answer) obj).getText();
            return this.text.equals(s);
        }
        return false;
    }
}
