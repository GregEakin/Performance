package book.paralleizing;

import info.jhpc.thread.*;

public class Warshall1 {
    final int numThreads;

    public Warshall1(int numThreads) {
        this.numThreads = numThreads;
    }

    private class Close extends Thread {
        final boolean[][] a;
        final int t;
        final SimpleBarrier b;
        final Accumulator done;

        Close(boolean[][] a, int t, SimpleBarrier b, Accumulator done) {
            this.a = a;
            this.t = t;
            this.b = b;
            this.done = done;
        }

        @Override
        public void run() {
            try {
                for (int k = 0; k < a.length; k++) {
                    for (int i = t; i < a.length; i += numThreads) {
                        if (a[i][k])
                            for (int j = 0; j < a.length; j++)
                                a[i][j] |= a[k][j];
                    }
                    b.gather();
                }
                done.signal();
            } catch (InterruptedException e) {
            }
        }
    }

    public void closure(boolean[][] a) {
        Accumulator done = new Accumulator(numThreads);
        SimpleBarrier b = new SimpleBarrier(numThreads);
        for (int i = 0; i < numThreads; i++)
            new Close(a, i, b, done).start();
        try {
            done.getFuture().getValue();
        } catch (InterruptedException e) {
        }
    }
}
