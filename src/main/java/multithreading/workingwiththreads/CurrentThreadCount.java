package multithreading.workingwiththreads;

public class CurrentThreadCount {
    public static void main(String[] args) {
        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);
        for (Thread thread : threads) {
            System.out.println(thread);
        }
    }
}
