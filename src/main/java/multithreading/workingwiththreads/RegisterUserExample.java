package multithreading.workingwiththreads;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class RegisterUserExample {
    public static void main(String[] args) throws InterruptedException {
        String username = "jlkesh";
        String email = "jlkesh#gmail.com";
        String password = "123";
        // validate(username,password,email)
        new Thread(() -> {
            try {
                runAsunc(() -> {
                    // TODO: 11/01/23 ...........
                    System.out.println("saved to database");
                });
                runAsunc(() -> {
                    // TODO: 11/01/23 ............
                    System.out.println("Generate Template");
                });
                runAsunc(() -> {
                    // TODO: 11/01/23  ..........
                    System.out.println("Send Email");
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        System.out.println("FINISHED..........");

    }

    private static void runAsunc(Runnable runnable) throws InterruptedException {
        new Thread(runnable).start();
    }
}
