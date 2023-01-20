package Services;

import dto.QuestionInput;
import dto.Result;
import dto.TestResult;

import java.util.Arrays;
import java.util.Scanner;

// toDo записать методы которые схожи для 10 и 9 ур.
public abstract class MainLevelExamination {
    public void print(QuestionInput[][] questions, int iForLevel, int iForQuestion) {
        System.out.println(questions[iForLevel][iForQuestion].getText());
        System.out.println("Enter one of answers as given \n" + Arrays.toString(questions[iForLevel][iForQuestion].getAnswer()));
    }
    public static String getInfoStudent() {
        Scanner in = new Scanner(System.in);
        System.out.println("Entre your full name:");
        return in.nextLine();
    }
}
