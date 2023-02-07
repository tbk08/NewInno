import Services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper objectMapper = new ObjectMapper();

        TestReader test = new TestReader();

        Examination nineLevelExaminationService = new OddLevelExaminationServiceImpl(9);
        Examination tenLevelExaminationService = new EvenLevelExaminationServiceImpl(10);
        TestResult testResult = tenLevelExaminationService.examination
                (test.fileReading("src/main/resources/inputTen.json"), scanner);

        String jsonTestResult = objectMapper.writeValueAsString(testResult);

        FileWriter fileWriter = new FileWriter();
        String path = "src/main/resources/results" + testResult.getStudentInfo() + ".json";
        fileWriter.writingFile(path, jsonTestResult);

    }
}
