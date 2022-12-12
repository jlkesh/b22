package uz.jl.blogpost.backend.daos;

import lombok.NonNull;
import uz.jl.blogpost.backend.criteria.UserCriteria;
import uz.jl.blogpost.backend.domains.User;
import uz.jl.blogpost.backend.dtos.user.UserDTO;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UserDAO extends GenericDAO<User, UserCriteria> implements AbstractDAO {

    private static UserDAO instance;


    public UserDAO() {
        super();
    }


    @Override
    protected void prepareCriteria(UserCriteria criteria) {
        Predicate<User> predicates = (user) -> !user.isDeleted();
        if (Objects.nonNull(criteria.getUsername())) {
            predicates = predicates.and(user -> user.getUsername().contains(criteria.getUsername()));
        }
        if (Objects.nonNull(criteria.getEmail())) {
            predicates = predicates.and(user -> user.getEmail().contains(criteria.getEmail()));
        }
        filter = predicates;
    }

    public User findByUsername(@NonNull String username) {
        Supplier<RuntimeException> runtimeExceptionSupplier = ()
                -> new RuntimeException("User not found by username %s".formatted(username));

        Predicate<User> isDeletedPredicate = user -> !user.isDeleted();
        Predicate<User> usernamePredicate = item -> item.getUsername().equals(username);
        Predicate<User> predicate = isDeletedPredicate.and(usernamePredicate);

        return data.stream()
                .parallel()
                .filter(predicate)
                .findAny()
                .orElseThrow(runtimeExceptionSupplier);
    }


    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public Optional<User> findById(String id) {
        Predicate<User> userPredicate = user -> user.getId().equals(id);
        return data.stream().filter(userPredicate).findAny();
    }

    public boolean update(@NonNull User user) {
        data.removeIf(user1 -> user1.getId().equals(user.getId()));
        save(user);
        return true;
    }

    public Optional<User> findByEmail(String email) {
        return data.stream().filter(user -> user.getEmail().equals(email)).findAny();
    }
}
