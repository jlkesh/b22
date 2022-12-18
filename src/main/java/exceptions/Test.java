package exceptions;

import java.sql.SQLException;

public class Test {
    public static void m4() throws SQLException {
        throw new SQLException("Database is down");
    }
}
