package structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTests {
    @Test
    public void emptyTestTrue() {
        Queue<Integer> queue = new Queue<Integer>(3);
        assertTrue(queue.empty());
    }

    @Test
    public void emptyTestFalse() {
        Queue<Integer> queue = new Queue<Integer>(3);
        queue.enqueue(15);
        assertFalse(queue.empty());
    }

    @Test
    public void pushPop() {
        Queue<Integer> queue = new Queue<Integer>(3);
        queue.enqueue(15);
        assertEquals(new Integer(15), queue.dequeue());
        assertTrue(queue.empty());
    }

    @Test
    public void pushPop2() {
        Queue<Integer> queue = new Queue<Integer>(3);
        queue.enqueue(15);
        queue.enqueue(5);
        assertEquals(new Integer(15), queue.dequeue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void popUnderflow() {
        Queue<Integer> queue = new Queue<Integer>(3);
        queue.dequeue();
    }

    @Test
    public void pushFull() {
        Queue<Integer> queue = new Queue<Integer>(3);
        for (int i = 0; i < 3; i++)
            queue.enqueue(i);
        assertEquals(new Integer(0), queue.dequeue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void pushOverflow() {
        Queue<Integer> queue = new Queue<Integer>(3);
        for (int i = 0; i < 4; i++)
            queue.enqueue(i);
    }
@Test
    public void popOverflow() {
        Queue<Integer> queue = new Queue<Integer>(3);
        try {
            for (int i = 0; i < 4; i++)
                queue.enqueue(i);
        } catch (IllegalArgumentException ex) {
        }
        assertEquals(new Integer(0), queue.dequeue());
    }
}
