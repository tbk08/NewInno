package dto;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {
    public void writingFile(String path, String studentName) throws IOException {
        // мне нужно сохранять файл results + имя студента но сначала надо разбраться куда собирать данные о студенте
        //toDo получать путь к файлу из вне
        // toDo текущий паз хранит в себе json а не путь
        File file = new File("src/main/resources/results"+studentName+".json");
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(path);
        printWriter.close();
    }
}
