package designpatterns.cd.builder;

public class UserBuilder {
    private String id;
    private String username;
    private String password;
    private String email;
    private int age;


    public UserBuilder id(String id) {
        this.id = id;
        return this;
    }

    public UserBuilder username(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder age(int age) {
        this.age = age;
        return this;
    }

    public User build() {
        return new User(id,username,password,email,age);
    }
}