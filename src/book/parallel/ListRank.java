package book.parallel;

import info.jhpc.thread.SimpleBarrier;
import org.junit.Test;
import structures.LinkedList;
import static org.junit.Assert.assertEquals;

public class ListRank<T> {
    public void Rank(LinkedList<T> list) {
        // Note: this destroys the structure of the next pointers
        // Make copies of the pointers, and use them instead

        // for each processor i, in parallel
        //   do if next[i] == nil
        //          d[i] = 0
        //      else
        //          d[i] = 1
        // while there exists an object i, such that next[i] != null
        //    do for each processor i, in parallel
        //           do if next[i] != null  {
        //                  d[i] += d[next[i]]
        //                  var next = next[next[i]];
        //                  barrier.gather();
        //                  // Note all the reads have to happen first
        //                  // then the first write can continue
        //                  next[i] = next[next[i]]
        //           }
    }

    public void Prefix(LinkedList<T> list) {
        // for each processor i, in parallel
        //       y[i] = x[i]
        // while there exists an object i, such that next[i] != null
        //    do for each processor i, in parallel
        //           do if next[i] != null  {
        //                  y[next[i]] = y[i] @ y[next[i]]
        //                  next[i] = next[next[i]]
        //           }
    }

    @Test
    public void Figure30() {
        int[] items = new int[]{3, 4, 6, 1, 0, 5};
        setup(items);
    }

    @Test
    public void Figure30Big() {
        int[] items = new int[1000];
        setup(items);
    }

    public void setup(int[] input) {
        int size = input.length;
        SimpleBarrier barrier = new SimpleBarrier(input.length);
        Node head = null;
        for (int i = input.length - 1; i >= 0; i--)
            head = new Node(barrier, i, input[i], head);

        Node node1 = head;
        while (node1 != null) {
            node1.start();
            node1 = node1.link;
        }

        try {
            Node node2 = head;
            while (node2 != null) {
                node2.join();
                assertEquals(--size, node2.d);
                node2 = node2.link;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


