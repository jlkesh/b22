package objectsclass;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Supplier;

public class ObjectsExample {
    public static void main(String[] args) {
        String obj = null;
        Supplier<String> supplier = () -> "Null mumkin emasda oka";
        // Objects.requireNonNull(obj, supplier);
        String hello = Objects.requireNonNullElse(obj, "hello");
        System.out.println("hello = " + hello);


    }
}
