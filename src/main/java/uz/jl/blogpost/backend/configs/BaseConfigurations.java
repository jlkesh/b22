package uz.jl.blogpost.backend.configs;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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

}
