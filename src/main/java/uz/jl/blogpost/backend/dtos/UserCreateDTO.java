package uz.jl.blogpost.backend.dtos;

public record UserCreateDTO(String username, String password, String email, String fullName) implements Dto {
}
