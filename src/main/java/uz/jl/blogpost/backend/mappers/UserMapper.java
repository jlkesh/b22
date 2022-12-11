package uz.jl.blogpost.backend.mappers;

import lombok.NonNull;
import uz.jl.blogpost.backend.domains.User;
import uz.jl.blogpost.backend.dtos.user.UserCreateDTO;
import uz.jl.blogpost.backend.dtos.user.UserDTO;
import uz.jl.blogpost.backend.dtos.user.UserUpdateDTO;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class UserMapper implements BaseMapper<User, UserDTO, UserCreateDTO, UserUpdateDTO> {

    private static UserMapper mapper;

    @Override
    public User fromCreateDTO(@NonNull UserCreateDTO dto) {
        return User.childBuilder()
                .username(dto.username())
                .password(dto.password())
                .email(dto.email())
                .fullName(dto.fullName())
                .status(User.Status.NOT_ACTIVE)
                .role(User.AuthRole.USER)
                .createdAt(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Tashkent"))))
                .language(User.Language.RU)
                .build();
    }

    @Override
    public User fromUpdateDTO(@NonNull UserCreateDTO dto) {
        return null;
    }

    @Override
    public UserDTO toDTO(@NonNull User domain) {
        return UserDTO.childBuilder()
                .id(domain.getId())
                .username(domain.getUsername())
                .role(domain.getRole().name())
                .status(domain.getStatus().name())
                .password(null)
                .email(domain.getEmail())
                .fullName(domain.getFullName())
                .language(domain.getLanguage().name())
                .build();
    }

    @Override
    public List<UserDTO> toDTO(@NonNull List<User> domain) {
        return null;
    }


    public static UserMapper getInstance() {
        if (mapper == null) {
            mapper = new UserMapper();
        }
        return mapper;
    }
}
