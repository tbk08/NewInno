package dto;

import java.util.Arrays;

public class Test {
    private String text;
    private int level;
    private Answer[] answer;
    private Answer trueAnswer;
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Answer[] getAnswer() {
        return answer;
    }

    public void setAnswer(Answer[] answer) {
        this.answer = answer;
    }

    public Answer getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(Answer trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public Test(String text, int level, Answer[] answer, Answer trueAnswer) {
        this.text = text;
        this.level = level;
        this.answer = answer;
        this.trueAnswer = trueAnswer;
    }

    @Override
    public String toString() {
        return "Test{" +
                "text='" + text + '\'' +
                ", level=" + level +
                ", answer=" + Arrays.toString(answer) +
                ", trueAnswer=" + trueAnswer +
                '}';
    }

    public Test() {
    }

}
