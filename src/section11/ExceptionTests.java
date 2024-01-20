package src.section11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExceptionTests {
    // public static void main(String[] args) {
    //     String[] array = {"one", "two", "three"};
    //     int num = 0;
    //     try {
    //         System.out.println(array.length / num);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     try {
    //         System.out.println(array[3]);
    //     } catch (ArrayIndexOutOfBoundsException e) {
    //         e.printStackTrace();
    //     }
    //     System.out.println("You made it to the end");
    // }

    public static void main(String[] args) {
        try {
            Files.lines(Path.of("blahblahblah"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("We were unable to open the file.");
        } finally {
            System.out.println("Make sure this runs no matter what...");
        }
    }
}
