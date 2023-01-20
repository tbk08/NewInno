import dto.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Массив получает данные из класса FileReader с помощью метода getTestData();
//        QuestionInput[][] questions = FileReader.getTestData();
//        QuestionInput[][] questions1 = FileReader.getQuestionNine();
//        // Создается объект класса TenLevelExamination для того чтобы проходить тест
//        TenLevelExamination testService = new TenLevelExamination();
//        NineLevelExamination nineLevelExamination = new NineLevelExamination();
//        // Создается объект класса ObjectMapper для того чтобы результат записывать в файлы output
//        ObjectMapper objectMapper = new ObjectMapper();
//        TestResult testResult=testService.examination(questions);
//        String jsonTestResult = objectMapper.writeValueAsString(testResult);
//
////         Создается объект класса FileWriter для записи результатов в новый файл
//        FileWriter fileWriter = new FileWriter();
//        fileWriter.writingFile(jsonTestResult, testResult.getStudentInfo());

        TestReader test = new TestReader();
        test.fileReading("src/main/resources/input.json");

        //ToDo переделать логику задавать рандомный вопрос
        //toDo два класса, 1 класс умеет читать файлы другой записывать
        //toDo результаты сохранялись в новые файлы, в класссе записывающий файл должно вводится имея студентва

    }
}
