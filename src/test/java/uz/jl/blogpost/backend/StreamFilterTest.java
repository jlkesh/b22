package uz.jl.blogpost.backend;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamFilterTest {

    @Test
    void test() {
        Stream<String> lStream = Stream.of("java", "python", "cpp");
        Predicate<String> predicate = null;
        List<String> strings = lStream.filter(predicate).toList();
        System.out.println(strings);
    }

}

