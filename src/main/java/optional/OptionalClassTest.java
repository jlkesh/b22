package optional;

import java.util.Optional;

public class OptionalClassTest {

    public static void main(String[] args) {
        var dd = Optional.ofNullable("ss");
        String s = dd.orElseThrow(() -> new RuntimeException("sad"));

        dd.ifPresentOrElse(data -> {
            // do some ..
        }, () -> {
            throw new RuntimeException("Exception");
        });
    }


}
