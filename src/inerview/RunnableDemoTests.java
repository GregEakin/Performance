package inerview;

import org.junit.Test;

/**
 * Created by Greg on 8/16/2016.
 */
public class RunnableDemoTests {
    @Test
    public void test1() {
        RunnableDemo R1 = new RunnableDemo("Thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo("Thread-2");
        R2.start();

        try {
            R1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            R2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
