package uz.jl.blogpost.backend.dtos.user;

import lombok.*;
import uz.jl.blogpost.backend.domains.User;
import uz.jl.blogpost.backend.dtos.GenericDto;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO extends GenericDto {
    private String fullName;
    private String username;
    private String password;
    private String status;
    private String email;
    private String role;
    private String language;
    private String createdAt;
    private String updatedAt;
    private String createdBy;
    private String updatedBy;

    @Builder(builderMethodName = "childBuilder")
    public UserDTO(String id, String fullName, String username, String password, String status, String email, String role, String language, String createdAt, String updatedAt, String createdBy, String updatedBy) {
        super(id);
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.status = status;
        this.email = email;
        this.role = role;
        this.language = language;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
