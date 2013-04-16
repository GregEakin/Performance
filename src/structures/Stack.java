package structures;

public class Stack {

    private final int[] data;
    private int top;

    public Stack(int n) {
        data = new int[n];
    }

    public boolean empty() {
        return top == 0;
    }

    public void push(int x) {
        top++;

        if (top > data.length)
            throw new IllegalArgumentException("overflow");

        data[top - 1] = x;
    }

    public int pop() {
        if (empty())
            throw new IllegalArgumentException("underflow");

        top--;
        return data[top];
    }
}
