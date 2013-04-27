package book.parallel;

import info.jhpc.thread.SimpleBarrier;
import org.junit.Test;
import structures.LinkedList;

public class ListRank<T> {
    public void RankBook(LinkedList<T> list) {
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
        //                  // Note all the reads have to happen first
        //                  // then the first write can continue
        //                  next[i] = next[next[i]]
        //           }
    }

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
        Integer[] items = new Integer[]{3, 4, 6, 1, 0, 5};
        setup(items);
    }

    public void setup(Integer[] input) {
        SimpleBarrier barrier = new SimpleBarrier(input.length);
        Thing head = null;
        Thing last = null;
        for (int i = 0; i < input.length; i++) {
            Thing node = new Thing(barrier, i, input[i]);
            if (last != null)
            {
                last.next = node;
                last.link = node;
            }
            last = node;
            if (i == 0)
                head = node;
        }

        Thing node1 = head;
        while (node1 != null) {
            node1.start();
            node1 = node1.link;
        }

        try {
            Thing node2 = head;
            while (node2 != null) {
                node2.join();
                System.out.println("Done " + node2.value + ", d = " + node2.d);
                node2 = node2.link;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


