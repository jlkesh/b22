package uz.jl.blogpost.backend.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.NonNull;
import org.mindrot.jbcrypt.BCrypt;
import uz.jl.blogpost.backend.type_adapters.LocalDateTimeAdapter;

import java.time.LocalDateTime;
import java.util.UUID;

public class BaseUtil {

    public static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .setDateFormat("YYYY/MM/DD HH:mm:SS")
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    public static String generateUniqueID() {
        return UUID.randomUUID().toString();
    }

    public String encode(@NonNull String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }

    public boolean match(@NonNull String rawPassword, @NonNull String encodedPassword) {
        return BCrypt.checkpw(rawPassword, encodedPassword);
    }

    public static Dotenv env() {
        return Dotenv.configure()
                .directory(".")
                .filename(".secrets")
                .load();
    }


}
