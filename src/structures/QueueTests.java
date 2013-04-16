package structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTests {
    @Test
    public void emptyTestTrue() {
        Queue queue = new Queue(3);
        assertTrue(queue.empty());
    }

    @Test
    public void emptyTestFalse() {
        Queue queue = new Queue(3);
        queue.enqueue(15);
        assertFalse(queue.empty());
    }

    @Test
    public void pushPop() {
        Queue queue = new Queue(3);
        queue.enqueue(15);
        assertEquals(15, queue.dequeue());
        assertTrue(queue.empty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void popUnderflow() {
        Queue queue = new Queue(3);
        queue.dequeue();
    }

    @Test
    public void pushFull() {
        Queue queue = new Queue(3);
        for (int i = 0; i < 3; i++)
            queue.enqueue(i);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pushOverflow() {
        Queue queue = new Queue(3);
        for (int i = 0; i < 4; i++)
            queue.enqueue(i);
    }
}
