package dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {

    private final String text;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Answer(@JsonProperty("text") String text) {
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