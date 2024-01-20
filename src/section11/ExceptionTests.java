package src.section11;

public class ExceptionTests {
    public static void main(String[] args) {
        String[] array = {"one", "two", "three"};
        int num = 0;
        try {
            System.out.println(array.length / num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(array[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("You made it to the end");   
    }
}
