package structures;

public class Queue {
    private int head;
    private int tail;
    private int size;
    private final int[] data;

    public Queue(int n) {
        data = new int[n];
    }

    public boolean empty() {
        return size == 0;
    }

    public void enqueue(int x) {
        if (size >= data.length)
            throw new IllegalArgumentException("overflow");

        data[tail] = x;
        tail = (tail) % data.length;
        size++;
    }

    public int dequeue() {
        if (size == 0)
            throw new IllegalArgumentException("underflow");

        int x = data[head];
        data[head] = 0;
        head = (head + 1) % data.length;
        size--;
        return x;
    }
}
