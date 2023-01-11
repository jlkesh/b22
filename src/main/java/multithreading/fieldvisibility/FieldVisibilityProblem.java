package multithreading.fieldvisibility;

public class FieldVisibilityProblem {
    public static void main(String[] args) throws InterruptedException {
        MyRun myRun = new MyRun();
        var th1 = new Thread(myRun, "FIRST");
        var th2 = new Thread(myRun, "SECOND");
        th1.start();
        th2.start();
        Thread.sleep(2000);
        myRun.stop();
    }
}


class MyRun implements Runnable {
    private volatile boolean go;

    @Override
    public void run() {
        go = true;
        while (go) {
        }
        System.out.println(Thread.currentThread() + "::end");
    }

    public void stop() {
        go = false;
    }
}