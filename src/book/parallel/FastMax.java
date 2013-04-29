package book.parallel;

import java.util.concurrent.*;

public class FastMax {

    public int max(int[] array) {
        int max = Integer.MIN_VALUE;
        int n = array.length;
        boolean[] m = new boolean[n];

        // in parallel
        for (int i = 0; i < n; i++)
            m[i] = true;

        // in parallel
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (array[i] < array[j])
                    m[i] = true;

        // in parallel
        for (int i = 0; i < n; i++)
            if (m[i])
                max = array[i];

        return max;
    }

    public void oops() throws InterruptedException {
        // Thread pool for the collectors.
        ExecutorService executor = Executors.newFixedThreadPool(20);
        // Futures of all collectors running in the pool.
        ConcurrentLinkedQueue<Future> collectors = new ConcurrentLinkedQueue<Future>();

        // Make my Callable.
        Callable<Void> c = new Tests1();
        // Start it up and keep track of it so we can find out when it has finished.
        collectors.add(executor.submit(c));

        executor.awaitTermination(10, TimeUnit.SECONDS);

    }

    public static class Tests1 implements Callable {
        @Override
        public Void call() throws Exception {
            return null;
        }
    }
}
