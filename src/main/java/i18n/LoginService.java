package i18n;

import javax.management.RuntimeMBeanException;
import java.util.*;

public class LoginService {
    static UserDB db = new UserDB();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Login : ");
        String login = scanner.nextLine();
        System.out.print("Password : ");
        String password = scanner.nextLine();
        String response = processLogin(login, password);
        System.out.println(response);
        scanner.close();
    }

    private static String processLogin(String login, String password) {
        User user = db.findByUsername(login);
        if (!user.password().equals(password))
            throw new RuntimeException("Bad credentials");
        return MessageTranslation.get("success.login", user.language());
    }
}


record User(String username, String password, String language) {
}

record UserDB() {
    public static final List<User> users = new ArrayList<>() {{
        add(new User("jlkesh", "123", "uz"));
        add(new User("bro", "12", "en"));
        add(new User("abdullo", "15", "tj"));
    }};

    public User findByUsername(String username) {
        return users.parallelStream().filter(user -> user.username().equals(username))
                .findAny()
                .orElseThrow(() -> new RuntimeException("User not found by username '%S'".formatted(username)));
    }
}

class MessageTranslation {
    static ResourceBundle en = ResourceBundle.getBundle("messages", Locale.ENGLISH);
    static ResourceBundle uz = ResourceBundle.getBundle("messages", Locale.forLanguageTag("uz"));
    static ResourceBundle tj = ResourceBundle.getBundle("messages", Locale.forLanguageTag("tj"));

    public static String get(String key, String lang) {
        return switch (lang) {
            case "uz" -> uz.getString(key);
            case "tj" -> tj.getString(key);
            default -> en.getString(key);
        };
    }
}