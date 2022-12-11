package uz.jl.blogpost.backend.utils;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseUtilTest {

    @Test
    void env() {
        Dotenv env = BaseUtil.env();
        System.out.println(env.get("SM"));
    }
}