package multithreading.workingwiththreads;

public class DaemonThreads {
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
        thread1.setDaemon(false);
        thread1.setName("32123");
        thread1.start();
        System.out.println(":Hello PDP");
        Thread.sleep(100);
    }
}
