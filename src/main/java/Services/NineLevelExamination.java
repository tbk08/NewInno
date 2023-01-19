package Services;

import dto.Answer;
import dto.QuestionInput;
import dto.Result;
import dto.TestResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NineLevelExamination extends MainLevelExamination implements Examination{
    @Override
    public TestResult examination(QuestionInput[][] questions) {
        Result[] results = new Result[10];
        String infoStudent = getInfoStudent();
        TestResult testResult = new TestResult(results,infoStudent);
        int level = 9;// кол-во уровней сложности
        int averageLevel = 5;// средний уровень сложности
        Scanner scanner = new Scanner(System.in);
        List<String> askedQuestion = new ArrayList<>();
        int breaking = 0;
        String check;
        int numberOfTry = 1;
        int iForQuestion = 0;
        int iForLevel = averageLevel - 1;
        int iForResultsFirst = 1;
        while (breaking != level) {
            if (!askedQuestion.contains(questions[iForLevel][iForQuestion].getText())) {
                askedQuestion.add(questions[iForLevel][iForQuestion].getText());
                print(questions, iForLevel, iForQuestion);
                check = scanner.nextLine();
                Answer answer = new Answer(check);
                if (questions[iForLevel][iForQuestion].getTrueAnswer().equals(answer)) {
                    results[iForResultsFirst] = new Result(questions[iForLevel][iForQuestion].getText(),
                            (iForLevel + 1), answer, "True");
                    iForResultsFirst++;
                    if(numberOfTry==1){
                        iForQuestion = randomNumber(iForLevel, level);
                        numberOfTry++;
                    }
                    else if(numberOfTry==2){
                        iForLevel++;
                        iForQuestion = randomNumber(iForLevel, level);
                        numberOfTry=1;
                    }
                } else {
                    results[iForResultsFirst] = new Result(questions[iForLevel][iForQuestion].getText(),
                            (iForLevel + 1), answer, "False");
                    iForResultsFirst++;
                    if(numberOfTry==1){
                        iForLevel--;
                        iForQuestion = randomNumber(iForLevel, level);
                        numberOfTry++;
                    }
                    else if(numberOfTry==2){
                        iForQuestion = randomNumber(iForLevel, level);
                        numberOfTry=1;
                    }
                }
                breaking++;
            } else {
                iForQuestion = randomNumber(iForLevel, level);
            }
        }
        return testResult;
    }
    public static int randomNumber(int iForLevel, int level) {
        int iForQuestion;
        if (iForLevel > 4) {
            iForQuestion = (int) (Math.random() * ((2 * (level - (iForLevel + 1))) + 1));
        } else if (iForLevel == 4) {
            iForQuestion = (int) (Math.random() * (2 * (level - (iForLevel + 1)))+1);
        } else {
            iForQuestion = (int) (Math.random() * (2 * (iForLevel+1)));
        }
        return iForQuestion;
    }
}
