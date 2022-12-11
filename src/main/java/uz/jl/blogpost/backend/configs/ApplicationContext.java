package uz.jl.blogpost.backend.configs;

import uz.jl.blogpost.backend.daos.UserDAO;
import uz.jl.blogpost.backend.mappers.UserMapper;
import uz.jl.blogpost.backend.services.UserService;
import uz.jl.blogpost.backend.services.UserServiceImpl;
import uz.jl.blogpost.backend.services.mail.MailService;
import uz.jl.blogpost.backend.utils.validators.UserValidator;

public class ApplicationContext {

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) {
        String simpleName = clazz.getSimpleName();
        return switch (simpleName) {
            case "UserDAO" -> (T) UserDAO.getInstance();
            case "UserMapper" -> (T) UserMapper.getInstance();
            case "UserValidator" -> (T) UserValidator.getInstance();
            case "UserService" -> (T) UserServiceImpl.getInstance();
            case "MailService" -> (T) MailService.getInstance();
            default -> throw new BeanNotFoundException("Bean not found with name %S".formatted(simpleName));
        };
    }

    public static class BeanNotFoundException extends RuntimeException {

        public BeanNotFoundException() {
            super("Bean not found");
        }

        public BeanNotFoundException(String message) {
            super(message);
        }
    }
}
