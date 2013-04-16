package structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTests {
    @Test
    public void emptyTestTrue() {
        Stack stack = new Stack(7);
        assertTrue(stack.empty());
    }

    @Test
    public void emptyTestFalse() {
        Stack stack = new Stack(7);
        stack.push(15);
        assertFalse(stack.empty());
    }

    @Test
    public void pushPop() {
        Stack stack = new Stack(7);
        stack.push(15);
        assertEquals(15, stack.pop());
        assertTrue(stack.empty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void popUnderflow() {
        Stack stack = new Stack(7);
        stack.pop();
    }

    @Test
    public void pushFull() {
        Stack stack = new Stack(3);
        for (int i = 0; i < 3; i++)
            stack.push(i);
        assertEquals(2, stack.pop());
    }

    @Test(expected = IllegalArgumentException.class)
    public void pushOverflow() {
        Stack stack = new Stack(3);
        for (int i = 0; i < 5; i++)
            stack.push(i);
    }

    @Test
    public void popAfterOverflow() {
        Stack stack = new Stack(3);
        try {
            for (int i = 0; i < 5; i++)
                stack.push(i);
        } catch (IllegalArgumentException ex) {
        }
        assertEquals(2, stack.pop());
    }
}
