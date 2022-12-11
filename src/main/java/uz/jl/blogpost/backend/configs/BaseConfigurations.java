package uz.jl.blogpost.backend.configs;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static uz.jl.blogpost.backend.utils.BaseUtil.env;

public class BaseConfigurations {

    private static final Properties p = load();


    public static String get(String property) {
        return p.getProperty(property, property);
    }


    private static Properties load() {
        Properties properties = new Properties();
        try {
            FileReader reader = new FileReader("src/main/resources/application.properties");
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static Properties getSMTPConfiguration() {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "465");
        String username = env().get("SMTP_USERNAME");
        String password = env().get("SMTP_PASSWORD");
        prop.put("username", username);
        prop.put("password", password);
        return prop;
    }
}
