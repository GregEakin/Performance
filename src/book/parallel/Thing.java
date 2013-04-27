package book.parallel;

import info.jhpc.thread.SimpleBarrier;

public class Thing extends Thread {
    final int i;
    final SimpleBarrier barrier;
    final int value;
    public int d;
    public Thing next;
    public Thing link;

    public Thing(SimpleBarrier barrier, int i, int value) {
        this.barrier = barrier;
        this.i = i;
        this.value = value;
    }

    @Override
    public void run() {
        try {
            function();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // System.out.println("Thread " + Thread.currentThread().getName() + " Exiting i = " + i + ", d = " + node.d);
    }

    private void function() throws InterruptedException {
        d = next == null ? 0 : 1;
        barrier.gather();

        while (next != null) {
            System.out.println("Thread i = " + i + ", d = " + d + ", next.d = " + next.d);
            d += next.d;
            Thing temp = next.next;
            barrier.gather();
            next = temp;
        }

        System.out.println("Thread i = " + i + ", d = " + d);
        barrier.exit();
    }
}
