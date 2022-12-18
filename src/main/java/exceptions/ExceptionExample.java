package exceptions;

import java.io.*;
import java.sql.SQLException;

import static exceptions.Test.m4;

public class ExceptionExample {

    public static void main(String[] args) {
        try {
            m3();
        } catch (SQLException e) {
            /*var t = e;
            var out = new StringWriter();
            t.printStackTrace(new PrintWriter(out));
            String description = out.toString();
            System.out.println(description);*/


        }
    }


    static void m1() throws SQLException {
        m2();
    }

    static void m2() throws SQLException {

    }

    static void m3() throws SQLException {
        StackWalker walker = StackWalker.getInstance();
        walker.forEach(frame -> {
            System.out.println(frame.toString());
        });
//        try {
        m4();
//        } catch (SQLException e) {
//            APIException apiException = new APIException("Internal server error");
//            apiException.initCause(e);
//            throw apiException;
//        } finally {
//            System.out.println("Finally Block called");
//        }
    }

    static int m5() throws APIException {
        try (InputStream is = new FileInputStream("")) {

            return 10;
        } catch (IOException e) {
        } finally {
            System.out.println("Finally Block called");
           /* if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }*/
            return 5;
        }
    }


}

class APIException extends Exception {
    public APIException(String message) {
        super(message);
    }
}