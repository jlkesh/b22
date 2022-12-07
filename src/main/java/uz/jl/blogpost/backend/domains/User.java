package uz.jl.blogpost.backend.domains;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private String id;
    private String fullName;
    private String username;
    private String password;

    @Builder.Default
    private Status status = Status.NOT_ACTIVE;

    private String email;

    @Builder.Default
    private AuthRole role = AuthRole.USER;

    @Builder.Default
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
        UZ, RU, EN
    }
}
