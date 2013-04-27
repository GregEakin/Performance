package structures;

public class LinkedList<T> {
    public int length;
    Node<T> head;
    int count;

    public int getCount() {
        return count;
    }

    public Node<T> getFirst() {
        return head;
    }

    public Node<T> getLast() {
        if (head != null)
            return head.prev;
        throw new IllegalArgumentException("underflow");
    }

    void removeFirst() {
        if (head == null)
            throw new IllegalArgumentException("underflow");
        count--;
        // remove node (head)
    }

    public void addLast(T item) {
        Node<T> node = new Node<T>();
        node.value = item;

        if (head == null)
        {
            head = node;
            head.next = head;
            head.prev = head;
        }
        else
        {
            head.prev.next = node;
            node.prev = head.prev.next;
            node.next = head;
            head.prev = node;
        }
        count++;
    }

    void removeLast() {
        if (head == null)
            throw new IllegalArgumentException("underflow");

        // removed node (head.prev);
    }

    public static class Node<T> {
        public Node<T> next;
        public T value;
        public Node<T> prev;
    }
}
