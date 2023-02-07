package dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

import java.nio.file.Paths;

public class TestReader {
    public Test[][] fileReading(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(Paths.get(path).toFile(), Test[][].class);
    }

}
