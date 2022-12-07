package uz.jl.blogpost.backend.services;

import uz.jl.blogpost.backend.criteria.UserCriteria;
import uz.jl.blogpost.backend.dtos.UserCreateDTO;
import uz.jl.blogpost.backend.dtos.UserDTO;
import uz.jl.blogpost.backend.dtos.UserUpdateDTO;

import java.util.List;

public class UserService implements GenericCrudService<UserDTO, UserCreateDTO, UserUpdateDTO, String, UserCriteria> {

    @Override
    public String create(UserCreateDTO dto) {
        return null;
    }

    @Override
    public Boolean update(UserUpdateDTO dto) {
        return null;
    }

    @Override
    public Boolean delete(String s) {
        return null;
    }

    @Override
    public UserDTO get(String s) {
        return null;
    }

    @Override
    public List<UserDTO> getAll(UserCriteria criteria) {
        return null;
    }
}
