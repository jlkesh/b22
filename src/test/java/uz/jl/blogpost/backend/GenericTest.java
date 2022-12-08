package uz.jl.blogpost.backend;

import org.junit.jupiter.api.Test;
import uz.jl.blogpost.backend.daos.CommentDAO;
import uz.jl.blogpost.backend.daos.UserDAO;
import uz.jl.blogpost.backend.domains.User;

public class GenericTest {

    @Test
    void persistanceClassTest() {
        UserDAO dao = new UserDAO();
        CommentDAO dao2 = new CommentDAO();
    }
}
