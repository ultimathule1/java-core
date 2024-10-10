package ru.sorokin.javacore.hw.exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WorkWithFile {
    private final String FILE_NAME_FOR_READING = "src/main/resources/exceptions/source.txt";
    private final String FILE_NAME_FOR_WRITING = "src/main/resources/exceptions/destination.txt";

    public String readFile() throws IOException {
        StringBuilder result = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_FOR_READING))) {
            String tempString;
            while ((tempString = br.readLine()) != null) {
                result.append(tempString).append("\n");
            }
        } catch (FileNotFoundException e) {
          throw e;
        } catch (IOException e) {
          throw e;
        }

        return result.toString();
    }

    public void writeFile(String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME_FOR_WRITING))) {
            bw.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
