package src.section10.Employee.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigData {
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            Long result = Files.lines(Path.of("src/section10/Employee/java/Hr5m.csv"))
                .skip(1)
                .map(s -> s.split(","))
                .map(arr -> arr[25])
                .mapToLong(sal -> Long.parseLong(sal))
                .sum();
            long endTime = System.currentTimeMillis();
            System.out.printf("$%,d.00%n", result);
            System.out.println(endTime - startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
