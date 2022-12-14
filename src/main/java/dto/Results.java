package dto;

public class Results {
    private String question;
    private int level;
    private Answer answer;
    private String checkResult;

    public String getQuestion() {
        return question;
    }

    public int getLevel() {
        return level;
    }

    public Answer getAnswer() {
        return answer;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public Results(String question, int level, Answer answer, String checkResult) {
        this.question = question;
        this.level = level;
        this.answer = answer;
        this.checkResult = checkResult;
    }

    @Override
    public String toString() {
        return "Results{" +
                "question='" + question + '\'' +
                ", level=" + level +
                ", answer=" + answer +
                ", checkResult='" + checkResult + '\'' +
                '}';
    }
}
