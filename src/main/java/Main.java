import Services.TestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Input;
import dto.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, JsonProcessingException {
        Question[][] questions = Input.getTestData();
        TestService testService = new TestService();
        ObjectMapper objectMapper = new ObjectMapper();
        String path = objectMapper.writeValueAsString(testService.examination(questions));
        File file = new File("src/main/resources/output.json");
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(path);
        printWriter.close();

    }
}
