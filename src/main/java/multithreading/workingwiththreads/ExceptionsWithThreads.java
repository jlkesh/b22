package multithreading.workingwiththreads;

public class ExceptionsWithThreads {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                Thread thread = Thread.currentThread();
                if (i == 10 && thread.getName().equals("ONE")) {
                    throw new RuntimeException("Elshod");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(thread + "::->" + i);

            }
        };
        var thread1 = new Thread(runnable, "ONE");
        var thread2 = new Thread(runnable, "TWO");
        thread1.start();
        thread2.start();
        System.out.println(12 / 0);

    }
}
