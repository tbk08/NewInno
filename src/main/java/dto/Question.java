package dto;
public class Question {
    private final String text;
    private final int level;

    private final Answer[] answer;

    private final Answer trueAnswer;

    public String getText() {
        return text;
    }

    public int getLevel() {
        return level;
    }

    public Answer[] getAnswer() {
        return answer;
    }

    public Answer getTrueAnswer() {
        return trueAnswer;
    }
    //я сделала конструктор публичным чтобы код работал это не сломает мой проект в будущем?
    public Question(String text, int level, Answer[] answer, Answer trueAnswer) {
        this.text = text;
        this.level = level;
        this.answer = answer;
        this.trueAnswer = trueAnswer;
    }

    @Override
    public String toString() {
        return text;
    }

}
