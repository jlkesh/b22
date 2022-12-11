package uz.jl.blogpost.backend.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uz.jl.blogpost.backend.configs.ApplicationContext;
import uz.jl.blogpost.backend.response.DataDTO;
import uz.jl.blogpost.backend.response.Response;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    UserService service = ApplicationContext.getBean(UserService.class);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {
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
    }

    @Test
    void login() {
    }
}