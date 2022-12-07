package gjkeee.daos;

import gjkeee.domains.BaseDomain;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

/**
 * @param <T>  Entity
 * @param <ID> Id for primary key
 */
public abstract class BaseDAO<T extends BaseDomain, ID extends Number> {
    private Connection connection = getConnection();

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("drv", "username", "password");
        } catch (SQLException e) {
            return null;
        }
    }

    abstract ID create(T t);

    abstract void delete(ID id);

    abstract List<T> getAll(T t);

    abstract T get();
}
