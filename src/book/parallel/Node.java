package book.parallel;

import info.jhpc.thread.SimpleBarrier;

public class Node extends Thread {
    final int i;
    final SimpleBarrier barrier;
    final int value;
    public int d;
    public Node next;
    public Node link;

    public Node(SimpleBarrier barrier, int i, int value) {
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
    }

    private void function() throws InterruptedException {
        next = link;
        d = next == null ? 0 : 1;
        barrier.gather();

        while (next != null) {
            int nextD = next.d;
            Node nextNode = next.next;
            barrier.gather();

            d += nextD;
            next = nextNode;
            barrier.gather();
        }
        barrier.exit();
    }
}
