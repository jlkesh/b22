package uz.jl.blogpost.backend.services;

import lombok.NonNull;
import uz.jl.blogpost.backend.criteria.UserCriteria;
import uz.jl.blogpost.backend.daos.UserDAO;
import uz.jl.blogpost.backend.domains.User;
import uz.jl.blogpost.backend.dtos.user.LoginRequest;
import uz.jl.blogpost.backend.dtos.user.UserCreateDTO;
import uz.jl.blogpost.backend.dtos.user.UserDTO;
import uz.jl.blogpost.backend.dtos.user.UserUpdateDTO;
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

    @Override
    public Response<DataDTO<UserDTO>> login(@NonNull LoginRequest loginRequest) {
        try {
            User user = dao.findByUsername(loginRequest.username());
            if (!util.match(loginRequest.password(), user.getPassword()))
                return new Response<>(new DataDTO<>(new ErrorDTO("Bad credentials")));
            UserDTO userDTO = mapper.toDTO(user);
            return new Response<>(new DataDTO<>(userDTO));
        } catch (RuntimeException e) {
            // TODO: 08/12/22 need to logger here
            return new Response<>(new DataDTO<>(new ErrorDTO("Bad credentials")));
        }
    }
}
