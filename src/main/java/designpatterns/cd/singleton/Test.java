package designpatterns.cd.singleton;


import java.security.SecurityPermission;

public class Test {
    public static void main(String[] args) {
        UserService userService = UserService.getInstance();

        // userService.create("Akbar");
        // System.out.println(userService.getAll());
        // UserService service = UserService.getInstance();
        // System.out.println(service.getAll());
        // System.out.println(service == userService);
    }
}
