package uz.jl.blogpost.backend.services;

import lombok.NonNull;
import uz.jl.blogpost.backend.criteria.UserCriteria;
import uz.jl.blogpost.backend.dtos.user.LoginRequest;
import uz.jl.blogpost.backend.dtos.user.UserCreateDTO;
import uz.jl.blogpost.backend.dtos.user.UserDTO;
import uz.jl.blogpost.backend.dtos.user.UserUpdateDTO;
import uz.jl.blogpost.backend.response.DataDTO;
import uz.jl.blogpost.backend.response.Response;
import uz.jl.blogpost.backend.services.base.GenericCrudService;

public interface UserService extends GenericCrudService<UserDTO, UserCreateDTO, UserUpdateDTO, String, UserCriteria> {
    Response<DataDTO<UserDTO>> login(@NonNull LoginRequest loginRequest);

    Response<DataDTO<Boolean>> forgetPassword(@NonNull String email);


}
