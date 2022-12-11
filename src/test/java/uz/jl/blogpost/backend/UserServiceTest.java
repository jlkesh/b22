package uz.jl.blogpost.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uz.jl.blogpost.backend.configs.ApplicationContext;
import uz.jl.blogpost.backend.daos.UserDAO;
import uz.jl.blogpost.backend.domains.User;
import uz.jl.blogpost.backend.dtos.user.LoginRequest;
import uz.jl.blogpost.backend.dtos.user.UserCreateDTO;
import uz.jl.blogpost.backend.dtos.user.UserDTO;
import uz.jl.blogpost.backend.dtos.user.UserUpdateDTO;
import uz.jl.blogpost.backend.response.DataDTO;
import uz.jl.blogpost.backend.response.Response;
import uz.jl.blogpost.backend.services.UserService;
import uz.jl.blogpost.backend.services.UserServiceImpl;

public class UserServiceTest {

    UserService service;
    UserDAO dao;


    @BeforeEach
    void setUp() {
        service = UserServiceImpl.getInstance();
        dao = ApplicationContext.getBean(UserDAO.class);
    }

    @Test
    void registerUserTest() {
        UserCreateDTO dto = new UserCreateDTO("abdullo", "123", "john@gmail.com", "Elmurodov Javohir");
        service.create(dto);
        dao.shutDownHook();
    }


    @Test
    void login_with_right_credentials_Test() {
        String username = "jl";
        String password = "123";
        LoginRequest loginRequest = new LoginRequest(username, password);
        Response<DataDTO<UserDTO>> response = service.login(loginRequest);
        DataDTO<UserDTO> data = response.data();
        System.out.println("data = " + data);
        Assertions.assertTrue(data.isSuccess());
    }

    @Test
    void update_user_test() {
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO(
                "c00972cf-1c20-442f-a0fc-0f7a45bda904",
                "Javohir Elmurodov Sayfullayevich",
                null,null, "john.lgd65@gmail.com");
        Response<DataDTO<Boolean>> response = service.update(userUpdateDTO);
        DataDTO<Boolean> data = response.data();
        System.out.println("data = " + data);
        dao.shutDownHook();
        Assertions.assertTrue(data.isSuccess());
    }

    @Test
    void login_with_bad_credentials_Test() {
        String username = "jl";
        String password = "1234";
        LoginRequest loginRequest = new LoginRequest(username, password);
        Response<DataDTO<UserDTO>> response = service.login(loginRequest);
        DataDTO<UserDTO> data = response.data();
        System.out.println(data.getError());
        Assertions.assertFalse(data.isSuccess());

    }
}
