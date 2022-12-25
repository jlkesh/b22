package collectionsframework.beforegenerics.dictionary;

import java.util.HashMap;

public class DictionaryTest {
    public static void main(String[] args) {


        Dictionary<String, User> d = new Dictionary<>();
        d.put("john", new User("john", "123", "ADMIN"));
        d.put("jl", new User("jl", "123", "MANAGER"));
        d.put("jlkesh", new User("jlkesh", "123", "CEO"));


    }
}

record User(String username, String password, String role) {
}