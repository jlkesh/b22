package uz.jl.blogpost.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uz.jl.blogpost.backend.daos.UserDAO;
import uz.jl.blogpost.backend.dtos.UserCreateDTO;
import uz.jl.blogpost.backend.mappers.UserMapper;
import uz.jl.blogpost.backend.services.UserService;
import uz.jl.blogpost.backend.services.UserServiceImpl;
import uz.jl.blogpost.backend.utils.validators.UserValidator;

public class UserServiceTest {
    UserDAO dao;
    UserMapper mapper;
    UserValidator validator;

    UserService service;


    @BeforeEach
    void setUp() {
        dao = new UserDAO();
        validator = new UserValidator();
        mapper = new UserMapper();
        service = new UserServiceImpl(dao, mapper, validator);
    }

    @Test
    void registerUserTest() {
        UserCreateDTO dto = new UserCreateDTO("jl", "123", "john@gmail.com", "Elmurodov Javohir");
        service.create(dto);
        dao.shutDownHook();
    }
}
