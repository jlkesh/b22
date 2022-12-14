package designpatterns.cd.singleton;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDAO {
    private static UserDAO instance = new UserDAO();

    public static UserDAO getInstance() {
        return instance;
    }

    List<String> names = new ArrayList<>();

    public void create(String name) {
        names.add(name);
    }
}
