package uz.jl.blogpost.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uz.jl.blogpost.backend.daos.UserDAO;
import uz.jl.blogpost.backend.dtos.user.LoginRequest;
import uz.jl.blogpost.backend.dtos.user.UserCreateDTO;
import uz.jl.blogpost.backend.dtos.user.UserDTO;
import uz.jl.blogpost.backend.mappers.UserMapper;
import uz.jl.blogpost.backend.response.DataDTO;
import uz.jl.blogpost.backend.response.Response;
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


    @Test
    void login() {
        String username = "jl";
        String password = "123";
        LoginRequest loginRequest = new LoginRequest(username, password);
        Response<DataDTO<UserDTO>> response = service.login(loginRequest);
        DataDTO<UserDTO> data = response.data();
        System.out.println(data);
        Assertions.assertTrue(data.isSuccess());



    }
}
