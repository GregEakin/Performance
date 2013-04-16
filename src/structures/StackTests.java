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
        Stack stack = new Stack(7);
        for (int i = 0; i < 7; i++)
            stack.push(i);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pushOverflow() {
        Stack stack = new Stack(7);
        for (int i = 0; i < 8; i++)
            stack.push(i);
    }
}
