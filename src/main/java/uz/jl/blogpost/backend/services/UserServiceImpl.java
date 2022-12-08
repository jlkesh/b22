package uz.jl.blogpost.backend.services;

import lombok.NonNull;
import uz.jl.blogpost.backend.criteria.UserCriteria;
import uz.jl.blogpost.backend.daos.UserDAO;
import uz.jl.blogpost.backend.domains.User;
import uz.jl.blogpost.backend.dtos.UserCreateDTO;
import uz.jl.blogpost.backend.dtos.UserDTO;
import uz.jl.blogpost.backend.dtos.UserUpdateDTO;
import uz.jl.blogpost.backend.mappers.UserMapper;
import uz.jl.blogpost.backend.response.Data;
import uz.jl.blogpost.backend.response.Response;
import uz.jl.blogpost.backend.services.base.AbstractService;
import uz.jl.blogpost.backend.utils.validators.UserValidator;

import java.util.List;
import java.util.logging.Logger;

public class UserServiceImpl extends AbstractService<UserDAO, UserMapper, UserValidator> implements UserService {

    private final Logger logger = Logger.getLogger(getClass().getName());

    public UserServiceImpl(UserDAO dao, UserMapper mapper, UserValidator validator) {
        super(dao, mapper, validator);
    }

    @Override
    public Response<Data<String>> create(@NonNull UserCreateDTO dto) {
        try {
            validator.checkOnCreate(dto);
            User user = mapper.fromCreateDTO(dto);
            user.setPassword(util.encode(user.getPassword()));
            dao.save(user);
            return new Response<>(new Data<>(user.getId()));
        } catch (IllegalArgumentException e) {
            logger.severe(e.getLocalizedMessage());
            Error error = new Error(e.getCause());
            return null;
//            return new Response<>(error);
        }
    }

    @Override
    public Response<Data<Boolean>> update(@NonNull UserUpdateDTO dto) {
        return null;
    }

    @Override
    public Response<Data<Boolean>> delete(@NonNull String s) {
        return null;
    }

    @Override
    public Response<Data<UserDTO>> get(@NonNull String s) {
        return null;
    }

    @Override
    public Response<Data<List<UserDTO>>> getAll(@NonNull UserCriteria criteria) {
        return null;
    }
}
