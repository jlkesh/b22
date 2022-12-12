package uz.jl.blogpost.backend.criteria;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserCriteria extends GenericCriteria {
    private String username;
    private String role;
    private String email;
}
