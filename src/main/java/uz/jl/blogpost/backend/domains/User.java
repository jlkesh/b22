package uz.jl.blogpost.backend.domains;

import lombok.*;
import uz.jl.blogpost.backend.configs.BaseConfigurations;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User extends BaseDomain {

    @NonNull
    private String fullName;

    @NonNull
    private String username;

    @NonNull
    private String password;

    private Status status = Status.NOT_ACTIVE;

    @NonNull
    private String email;

    private AuthRole role = AuthRole.USER;

    private Language language = Language.RU;

    public enum Status {
        ACTIVE(0),
        NOT_ACTIVE(-1),
        BLOCKED(-50),
        BANNED(-100);
        private final int level;

        Status(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }

    public enum AuthRole {
        ADMIN, USER;
    }

    public enum Language {
        UZ, RU, EN;

        public static Language getByName(String languageName) {
            for (Language language : values()) {
                if (language.name().equalsIgnoreCase(languageName)) {
                    return language;
                }

            }
            return Language.RU;
        }
    }

    @Builder(builderMethodName = "childBuilder")
    public User(String id, boolean deleted, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, @NonNull String fullName, @NonNull String username, @NonNull String password, Status status, @NonNull String email, AuthRole role, Language language) {
        super(id, deleted, createdAt, updatedAt, createdBy, updatedBy);
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.status = status;
        this.email = email;
        this.role = role;
        this.language = language;
    }


}
