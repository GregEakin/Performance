package heaps.leftist;

import org.approvaltests.Approvals;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Greg on 7/5/2014.
 */
public class HeapTest {
    @Test
    public void parent() throws Exception {
        int[] array = new int[]{4, 8, 10, 9, 1, 3, 5, 6, 11};
        Heap heap = new Heap(array);
        Approvals.verify(heap.toString());
//        assertEquals(0, heap.parent(1));
//        assertEquals(1, heap.parent(2));
//        assertEquals(1, heap.parent(3));
//        assertEquals(2, heap.parent(4));
    }
}
