package uz.jl.blogpost.backend.dtos.user;

import uz.jl.blogpost.backend.dtos.Dto;

public record UserCreateDTO(String username, String password, String email, String fullName) implements Dto {
}
