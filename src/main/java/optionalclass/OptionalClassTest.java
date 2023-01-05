package optionalclass;

import gjkeee.domains.User;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class OptionalClassTest {
    public static void main(String[] args) {

        Optional<String> java = Optional.of("Java");
        var o = new UserService();
        Optional<Object> optionalObject = o.findByUsername("jl");
        optionalObject.ifPresent(obj -> System.out.println(obj));
        optionalObject.ifPresentOrElse(
                (i)->{},
                ()->{});

    }
}

record UserService() {


    public Optional<Object> findByUsername(String username) {
        if (new Random().nextBoolean()) {
            return Optional.of("USER");
        }
        return Optional.empty();
    }

}
