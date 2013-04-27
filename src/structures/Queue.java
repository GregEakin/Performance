package structures;

public class Queue<T> {
    private int head;
    private int tail;
    private int size;
    private final Object[] data;

    public Queue(int n) {
        data = new Object[n];
    }

    public boolean empty() {
        return size == 0;
    }

    public void enqueue(T x) {
        if (size >= data.length)
            throw new IllegalArgumentException("overflow");

        data[tail] = x;
        tail = (tail) % data.length;
        size++;
    }

    public T dequeue() {
        if (size == 0)
            throw new IllegalArgumentException("underflow");

        T x = (T)data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        return x;
    }
}
