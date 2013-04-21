package book.paralleizing;

import info.jhpc.thread.*;

public class Warshall2 {
    final int numThreads;

    public Warshall2(int numThreads) {
        this.numThreads = numThreads;
    }

    private class Close extends Thread {
        final boolean[][] a;
        final DynAlloc d;
        final SimpleBarrier b;
        final Accumulator done;

        Close(boolean[][] a, DynAlloc d, SimpleBarrier b, Accumulator done) {
            this.a = a;
            this.d = d;
            this.b = b;
            this.done = done;
        }

        @Override
        public void run() {
            try {
                DynAlloc.Range r = new DynAlloc.Range();
                for (int k = 0; k < a.length; k++) {
                    while (d.alloc(r)) {
                        for (int i = r.start; i < r.end; i++) {
                            if (a[i][k])
                                for (int j = 0; j < a.length; j++)
                                    a[i][j] |= a[k][j];
                        }
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
        DynAlloc d = new DynAllocShare(a.length, numThreads, 2);
        for (int i = 0; i < numThreads; i++)
            new Close(a, d, b, done).start();
        try {
            done.getFuture().getValue();
        } catch (InterruptedException e) {
        }
    }
}
