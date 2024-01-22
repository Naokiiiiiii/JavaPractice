package src.section11.datastore;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optMsg = Optional.of("Hello");
        System.out.println(optMsg);

        String msg2 = "catastrophe";
        Optional<String> optMsg2 = Optional.ofNullable(msg2);
        System.out.println(optMsg2.filter(s -> s.length() > 3).orElse("Invalid"));
    }
}
