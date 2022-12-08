package uz.jl.blogpost.backend.daos;

import lombok.NonNull;
import uz.jl.blogpost.backend.domains.User;
import uz.jl.blogpost.backend.dtos.user.UserDTO;

import java.util.Optional;
import java.util.function.Supplier;

public class UserDAO extends GenericDAO<User> implements AbstractDAO {


    public UserDAO() {
        super();
    }

    public User findByUsername(@NonNull String username) {
        Supplier<RuntimeException> runtimeExceptionSupplier = ()
                -> new RuntimeException("User not found by username %s".formatted(username));

        return data.stream().filter(item -> item.getUsername().equals(username))
                .findAny()
                .orElseThrow(runtimeExceptionSupplier);
    }
}
