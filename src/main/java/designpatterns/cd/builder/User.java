package designpatterns.cd.builder;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private int age;

    public User(String id, String username, String password, String email, int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }



    public static void main(String[] args) {
        UserBuilder builder = User.builder();

        builder = builder.username("john");
        builder = builder.password("123");

        User user = builder.build();
        System.out.println(user);
    }

}
