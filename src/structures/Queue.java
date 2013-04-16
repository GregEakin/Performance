package structures;

public class Queue {
    private int head;
    private int tail;
    private final int[] data;

    public Queue(int n) {
        data = new int[n + 1];
        head = 1;
        tail = 1;
    }

    public boolean empty() {
        return head == tail;
    }

    public void enqueue(int x) {
        data[tail - 1] = x;
        if (tail == data.length)
            tail = 1;
        else
            tail++;

        if (empty())
            throw new IllegalArgumentException("overflow");
    }

    public int dequeue() {
        if (empty())
            throw new IllegalArgumentException("underflow");

        int x = data[head - 1];
        if (head == data.length)
            head = 1;
        else
            head++;
        return x;
    }
}
