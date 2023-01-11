package multithreading.workingwiththreads;

import javax.imageio.plugins.tiff.TIFFImageReadParam;

public class ThreadMethods {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                Thread thread = Thread.currentThread();
                System.out.println(thread + "::" + i);
            }
        };
        var thread1 = new Thread(runnable,"NoName");
        var thread2 = new Thread(runnable,"DinoPro");
        thread1.start();
        thread1.join(30);
        thread2.start();
        System.out.println("Hello World");
    }
}
