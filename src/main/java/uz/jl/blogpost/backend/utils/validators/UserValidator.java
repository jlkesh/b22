package uz.jl.blogpost.backend.utils.validators;

import lombok.NonNull;
import uz.jl.blogpost.backend.dtos.user.UserCreateDTO;
import uz.jl.blogpost.backend.dtos.user.UserUpdateDTO;

import java.util.Objects;
import java.util.regex.Pattern;

public class UserValidator extends AbstractValidator<UserCreateDTO, UserUpdateDTO, String> {

    private static UserValidator validator;

    @Override
    public void checkOnCreate(UserCreateDTO dto) throws IllegalArgumentException {
        if (Objects.isNull(dto))
            throw new IllegalArgumentException("DTO is null");
    }

    public void checkStrongPassword(@NonNull String password) {
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        if (pattern.matcher(password).find()) {
            // throw exception
        }
    }

    public static UserValidator getInstance() {
        if (validator == null) {
            validator = new UserValidator();
        }
        return validator;
    }
}
