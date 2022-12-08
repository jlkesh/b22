package uz.jl.blogpost.backend.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NonNull;
import org.mindrot.jbcrypt.BCrypt;

import java.util.UUID;

public class BaseUtil {

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static String generateUniqueID() {
        return UUID.randomUUID().toString();
    }
    public String encode(@NonNull String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }

    public boolean match(@NonNull String rawPassword,@NonNull String encodedPassword) {
        return BCrypt.checkpw(rawPassword, encodedPassword);
    }


}
