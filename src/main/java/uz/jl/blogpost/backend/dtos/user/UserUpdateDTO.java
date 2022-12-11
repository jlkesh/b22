package uz.jl.blogpost.backend.dtos.user;

import lombok.Builder;
import lombok.Data;
import uz.jl.blogpost.backend.dtos.GenericDto;


@Data
public class UserUpdateDTO extends GenericDto {
    private String fullName;
    private String username;
    private String language;
    private String email;


    @Builder(builderMethodName = "childBuilder")
    public UserUpdateDTO(String id, String fullName, String username, String language,String email) {
        super(id);
        this.fullName = fullName;
        this.username = username;
        this.language = language;
        this.email = email;
    }
}
