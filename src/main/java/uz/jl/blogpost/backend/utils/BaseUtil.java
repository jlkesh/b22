package uz.jl.blogpost.backend.utils;

import lombok.NonNull;
import org.mindrot.jbcrypt.BCrypt;

import java.util.StringTokenizer;

public class BaseUtil {
    public String encode(@NonNull String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }

    public boolean match(@NonNull String rawPassword,@NonNull String encodedPassword) {
        return BCrypt.checkpw(rawPassword, encodedPassword);
    }


}
