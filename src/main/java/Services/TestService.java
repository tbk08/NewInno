package Services;

import dto.Answer;
import dto.Question;
import dto.Results;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TestService implements Merger {
    public Results[] examination(Question[][] questions) {
        Results[] results = new Results[10];
        int level = 10;// кол-во уровней сложности
        int averageLevel = 5;// средний уровень сложности
        Scanner scanner = new Scanner(System.in);
        List<String> askedQuestion = new ArrayList<>();
        int breaking = 0;
        String check;
        int numberOfTry = 1;
        int iForQuestion = 0;
        int iForLevel = averageLevel - 1;
        int stop = 0;
        int iForResultsFirst = 0;
        while (breaking != level) {
            if (!askedQuestion.contains(questions[iForLevel][iForQuestion].getText())) {
                askedQuestion.add(questions[iForLevel][iForQuestion].getText());
                print(questions, iForLevel, iForQuestion);
                check = scanner.nextLine();
                Answer answer = new Answer(check);
                if (questions[iForLevel][iForQuestion].getTrueAnswer().equals(answer)) {
                    results[iForResultsFirst] =
                            new Results(questions[iForLevel][iForQuestion].getText(), (iForLevel + 1), answer, "True");
                    iForResultsFirst++;
                    if (iForLevel == 4 && stop == 0) {
                        numberOfTry = 1;
                        iForLevel++;
                        iForQuestion = 0;
                        stop = 1;
                    } else if (numberOfTry == 1 && stop == 1) {
                        iForQuestion++;
                        numberOfTry++;
                    } else if (numberOfTry == 2 && stop == 1) {
                        iForLevel++;
                        iForQuestion = 0;
                        numberOfTry = 1;
                    }
                    breaking++;
                } else {
                    results[iForResultsFirst] =
                            new Results(questions[iForLevel][iForQuestion].getText(),
                                    (iForLevel + 1), answer, "False");
                    iForResultsFirst++;
                    if (numberOfTry == 1 && iForLevel > 4) {
                        iForLevel--;
                        iForQuestion = 0;
                    } else if (numberOfTry == 2 && iForLevel > 4) {
                        iForQuestion++;
                        numberOfTry = 1;
                    } else if (numberOfTry == 1) {
                        numberOfTry++;
                        iForQuestion++;
                    } else if (numberOfTry == 2) {
                        numberOfTry = 1;
                        iForLevel--;
                        iForQuestion = 0;
                    }
                    breaking++;
                }
            } else {
                iForQuestion++;
            }
        }
        return results;
    }

    public void print(Question[][] questions, int iForLevel, int iForQuestion) {
        System.out.println(questions[iForLevel][iForQuestion].getText());
        for (Answer i : questions[iForLevel][iForQuestion].getAnswer()
        ) {
            System.out.println(i);
        }
    }
}
