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
        if (top >= data.length)
            throw new IllegalArgumentException("overflow");

        data[top] = x;
        top++;
    }

    public int pop() {
        if (empty())
            throw new IllegalArgumentException("underflow");

        top--;
        int i = data[top];
        data[top] = 0;
        return i;
    }
}
