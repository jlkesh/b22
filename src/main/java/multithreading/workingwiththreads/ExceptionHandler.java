package multithreading.workingwiththreads;

public class ExceptionHandler {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((Thread thread, Throwable throwable) -> {
            System.err.println(thread + "::" + throwable.getMessage());
        });
        Runnable runnable = () -> {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread thread = Thread.currentThread();
                    if (i == 10)
                        throw new RuntimeException("Elshod");
                    Thread.sleep(100);
                    System.out.println(thread + "::->" + i);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        var thread1 = new Thread(runnable, "ONE");
        thread1.setPriority(9);
        thread1.start();
        System.out.println(12 / 3);

    }
}
