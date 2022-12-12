package uz.jl.blogpost.backend.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uz.jl.blogpost.backend.configs.ApplicationContext;
import uz.jl.blogpost.backend.criteria.UserCriteria;
import uz.jl.blogpost.backend.daos.UserDAO;
import uz.jl.blogpost.backend.dtos.user.UserCreateDTO;
import uz.jl.blogpost.backend.dtos.user.UserDTO;
import uz.jl.blogpost.backend.response.DataDTO;
import uz.jl.blogpost.backend.response.Response;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    UserService service = ApplicationContext.getBean(UserService.class);
    UserDAO dao = ApplicationContext.getBean("UserDAO");

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {
        UserCreateDTO dto = new UserCreateDTO("mashennik", "123", "akbarovakbar@gmail.com", "Abdulloh Elmurodov");
        service.create(dto);
        dao.shutDownHook();
    }

    @Test
    void update() {
    }

    @Test
    void forgetPassword() {
        Response<DataDTO<Boolean>> response = service.forgetPassword("john.lgd65@gmail.com");
        DataDTO<Boolean> data = response.data();
        Assertions.assertTrue(data.isSuccess());
    }

    @Test
    void forgetPasswordConfirmation() {
    }

    @Test
    void delete() {
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
        Response<DataDTO<List<UserDTO>>> response = service.getAll(UserCriteria.builder()
                .email("gm")
                .username("mash")
                .build());
        System.out.println(response.data());
    }

    @Test
    void login() {
    }
}