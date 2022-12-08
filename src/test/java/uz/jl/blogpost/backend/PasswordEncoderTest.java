package uz.jl.blogpost.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uz.jl.blogpost.backend.utils.BaseUtil;


public class PasswordEncoderTest {

    @Test
    void checkPassword() {
        BaseUtil util = new BaseUtil();
        String rawPassword = "123";
        String encodedPassword = util.encode(rawPassword);
        System.out.println("encodedPassword = " + encodedPassword);
        Assertions.assertTrue(util.match(rawPassword,encodedPassword));
    }

}
