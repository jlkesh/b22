package uz.jl.blogpost.backend.response;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Error {
    private String friendlyMessage;
    private String developerMessage;
    private Throwable throwable;

    public Error(@NonNull Throwable throwable) {
        this(throwable.getLocalizedMessage(), throwable.getMessage(), throwable);
    }

    public Error(String friendlyMessage) {
        this(friendlyMessage, friendlyMessage);
    }

    public Error(String friendlyMessage, String developerMessage) {
        this(friendlyMessage, friendlyMessage, null);
    }

    public Error(String friendlyMessage, String developerMessage, Throwable throwable) {
        this.friendlyMessage = friendlyMessage;
        this.developerMessage = developerMessage;
        this.throwable = throwable;
    }
}
