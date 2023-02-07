package Services;

import dto.Answer;
import dto.Result;
import dto.Test;
import dto.TestResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OddLevelExaminationServiceImpl extends MainLevelExamination implements Examination {

    private final int level; // кол-во уровней сложности

    public OddLevelExaminationServiceImpl(int level) {
        this.level = level;
    }

    @Override
    public TestResult examination(Test[][] questions, Scanner scanner) {
        Result[] results = new Result[level];
        String infoStudent = getInfoStudent();
        TestResult testResult = new TestResult(results, infoStudent);

        List<Test> askedQuestion = new ArrayList<>();
        int iForResultsFirst = 0;
        int numberOfTry = 1;
        int breaking = 0;
        String check = "";
        int iForLevel = level / 2;
        boolean checkResult;

        while (breaking != level) {
            // уникальный вопрос для текущего ур.
            Test currentQuestion = getCurrentQuestion(questions, askedQuestion, iForLevel);
            askedQuestion.add(currentQuestion);
            //  вывести студенту вопрос на экран, прочитать ответ студента
            Answer answer = convertingPrint(currentQuestion, check);
            // проверить результат вопроса
            checkResult = checkAnswer(currentQuestion, answer);
            // сохранить результат вопроса
            results[iForResultsFirst] = saveResult(checkResult, currentQuestion, answer);
            iForResultsFirst++;
            // дай следующий ур.
            iForLevel = nextIForLevel(checkResult, numberOfTry, iForLevel);
            numberOfTry = nextIForNumberOfTry(checkResult, numberOfTry);
            breaking++;
        }
        return testResult;
    }


}
