package uz.jl.blogpost.backend.utils.validators;

import uz.jl.blogpost.backend.dtos.UserCreateDTO;
import uz.jl.blogpost.backend.dtos.UserUpdateDTO;

import java.util.Objects;

public class UserValidator extends AbstractValidator<UserCreateDTO, UserUpdateDTO, String> {
    @Override
    public void checkOnCreate(UserCreateDTO dto) throws IllegalArgumentException {
        if (Objects.isNull(dto))
            throw new IllegalArgumentException("DTO is null");
    }
}
