package inerview;

/**
 * Created by http://www.tutorialspoint.com/java/java_multithreading.htm
 */
public class RunnableDemo implements Runnable {
    private final String threadName;
    private final Thread t;

    RunnableDemo(String name) {
        threadName = name;
        t = new Thread(this, threadName);
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t.getState() == Thread.State.NEW)
            t.start();
        else
            throw new Error("Thread in invalid state.");
    }

    public void join() throws InterruptedException {
        if (t.getState() == Thread.State.RUNNABLE)
            t.join();
        else
            throw new Error("Thread in invalid state.");
    }
}
