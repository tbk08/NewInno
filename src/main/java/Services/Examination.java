package Services;

import dto.Test;
import dto.TestResult;

import java.util.Scanner;

public interface Examination {
    TestResult examination(Test[][] questions, Scanner scanner);
}
