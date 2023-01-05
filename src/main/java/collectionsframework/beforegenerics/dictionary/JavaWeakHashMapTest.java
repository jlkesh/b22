package collectionsframework.beforegenerics.dictionary;

import lombok.SneakyThrows;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class JavaWeakHashMapTest {

    public static void main(String[] args) {
        try {
            extracted();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void extracted() throws InterruptedException {
        WeakHashMap<String, String> whm = new WeakHashMap<>();
        String key = new String("1");
        whm.put(key, "Java");
        whm.put("2", "Scala");
        whm.put("3", "Groovy");
        whm.put("4", "Kotlin");
        key = null;
        whm.forEach((k, v) -> System.out.println(k + ":" + v));
        System.out.println("-------------------");
        System.gc();
        whm.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
