package multithreading.workingwiththreads;

public class ThreadClassTest {
    public static void main(String[] args) throws InterruptedException {
        //MyClass myClass = new MyClass();
       /* MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);*/

        Runnable runnable = () -> { // do not use
            for (int i = 0; i < 2000; i++) {
                System.out.println(i);
            }
        };
        System.out.println("Do not use Hello World 1");
//        new Thread(runnable).start(); // do not use

        new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                System.out.println(i);
            }
        }).start();

        Thread.sleep(5);
        System.out.println("Do not use Hello World 2");
    }
}

class MyClass extends Thread { // do not use this
    @Override
    public void run() {
        for (int i = 0; i < 2_000; i++) {
            System.out.println(i);
        }
    }
}

class MyRunnable implements Runnable { // do not use this
    @Override
    public void run() {
        for (int i = 0; i < 2_000; i++) {
            System.out.println(i);
        }
    }
}
