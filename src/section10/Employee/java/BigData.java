package src.section10.Employee.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigData {
    public static void main(String[] args) {
        try {
            Files.lines(Path.of("src/section10/Employee/java/Hr5m.csv"))
                .limit(5)
                .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
