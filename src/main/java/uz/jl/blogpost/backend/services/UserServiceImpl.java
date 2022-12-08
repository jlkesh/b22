package uz.jl.blogpost.backend.services;

import lombok.NonNull;
import uz.jl.blogpost.backend.criteria.UserCriteria;
import uz.jl.blogpost.backend.daos.UserDAO;
import uz.jl.blogpost.backend.domains.User;
import uz.jl.blogpost.backend.dtos.UserCreateDTO;
import uz.jl.blogpost.backend.dtos.UserDTO;
import uz.jl.blogpost.backend.dtos.UserUpdateDTO;
import uz.jl.blogpost.backend.mappers.UserMapper;
import uz.jl.blogpost.backend.response.DataDTO;
import uz.jl.blogpost.backend.response.ErrorDTO;
import uz.jl.blogpost.backend.response.Response;
import uz.jl.blogpost.backend.services.base.AbstractService;
import uz.jl.blogpost.backend.utils.BaseUtil;
import uz.jl.blogpost.backend.utils.validators.UserValidator;

import java.util.List;
import java.util.logging.Logger;

public class UserServiceImpl extends AbstractService<UserDAO, UserMapper, UserValidator> implements UserService {

    private final Logger logger = Logger.getLogger(getClass().getName());

    public UserServiceImpl(UserDAO dao, UserMapper mapper, UserValidator validator) {
        super(dao, mapper, validator);
    }

    @Override
    public Response<DataDTO<String>> create(@NonNull UserCreateDTO dto) {
        try {
            validator.checkOnCreate(dto);
            User user = mapper.fromCreateDTO(dto);
            user.setPassword(util.encode(user.getPassword()));
            user.setId(BaseUtil.generateUniqueID());
            dao.save(user);
            return new Response<>(new DataDTO<>(user.getId()));
        } catch (IllegalArgumentException e) {
            logger.severe(e.getLocalizedMessage());
            ErrorDTO error = new ErrorDTO(e.getCause());
            return new Response<>(new DataDTO<>(error));
        }
    }

    @Override
    public Response<DataDTO<Boolean>> update(@NonNull UserUpdateDTO dto) {
        return null;
    }

    @Override
    public Response<DataDTO<Boolean>> delete(@NonNull String s) {
        return null;
    }

    @Override
    public Response<DataDTO<UserDTO>> get(@NonNull String s) {
        return null;
    }

    @Override
    public Response<DataDTO<List<UserDTO>>> getAll(@NonNull UserCriteria criteria) {
        return null;
    }
}
