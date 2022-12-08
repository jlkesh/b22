package uz.jl.blogpost.backend.services;

import uz.jl.blogpost.backend.criteria.UserCriteria;
import uz.jl.blogpost.backend.dtos.UserCreateDTO;
import uz.jl.blogpost.backend.dtos.UserDTO;
import uz.jl.blogpost.backend.dtos.UserUpdateDTO;
import uz.jl.blogpost.backend.services.base.GenericCrudService;

public interface UserService extends GenericCrudService<UserDTO, UserCreateDTO, UserUpdateDTO, String, UserCriteria> {
}
