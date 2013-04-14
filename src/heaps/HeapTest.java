package heaps;

import org.approvaltests.Approvals;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {
    @Test
    public void Parent() {
        int[] array = new int[]{16, 14, 10, 8};
        Heap heap = new Heap(array);
        assertEquals(0, heap.parent(1));
        assertEquals(1, heap.parent(2));
        assertEquals(1, heap.parent(3));
        assertEquals(2, heap.parent(4));
    }

    @Test
    public void Left() {
        int[] array = new int[]{16, 14, 10, 8};
        Heap heap = new Heap(array);
        assertEquals(2, heap.left(1));
        assertEquals(4, heap.left(2));
        assertEquals(6, heap.left(3));
        assertEquals(8, heap.left(4));
    }

    @Test
    public void Right() {
        int[] array = new int[]{16, 14, 10, 8};
        Heap heap = new Heap(array);
        assertEquals(3, heap.right(1));
        assertEquals(5, heap.right(2));
        assertEquals(7, heap.right(3));
        assertEquals(9, heap.right(4));
    }

    @Test
    public void DumpStr() throws Exception {
        int[] array = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        Heap heap = new Heap(array);
        Approvals.verify(heap.toString());
    }

    @Test
    public void IsHeap1() throws Exception {
        int[] array = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        Heap heap = new Heap(array);
        assertTrue(heap.isHeap());
    }

    @Test
    public void IsHeap2() throws Exception {
        int[] array = new int[]{23, 17, 14, 6, 13, 10, 1, 5, 7, 12};
        Heap heap = new Heap(array);
        assertFalse(heap.isHeap());
    }

    @Test
    public void Heapify() throws Exception {
        int[] array = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        Heap heap = new Heap(array);
        assertFalse(heap.isHeap());
        heap.heapify(2);
        assertTrue(heap.isHeap());
        Approvals.verify(heap.toString());
    }

    @Test
    public void BuildHeap() throws Exception {
        int[] array = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        Heap heap = new Heap(array);
        heap.buildHeap();
        assertTrue(heap.isHeap());
        Approvals.verify(heap.toString());
    }

    @Test
    public void Heapsort() throws Exception {
        int[] array = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        Heap heap = new Heap(array);
        heap.heapsort();
        assertArrayEquals(new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16}, heap.getArray());
        Approvals.verify(heap.toString());
    }

    @Test
    public void HeapInsert() throws Exception {
        int[] array = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        Heap heap = new Heap(array);
        heap.heapInsert(15);
        Approvals.verify(heap.toString());
    }
}
