package multithreading.workingwiththreads;

public class InterruptingThreads {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread thread = Thread.currentThread();
                    Thread.sleep(100);
                    System.out.println(thread + "::->" + i);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };
        var thread1 = new Thread(runnable, "ONE");
        thread1.start();
        Thread.sleep(400);
        thread1.interrupt();

    }
}
