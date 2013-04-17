package structures;

public class LinkedList {
    Object head;
    int count;

    public int getCount()
    {
        return count;
    }

    public int getFirst()
    {
        return 0; // head;
    }

    public int getLast()
    {
        if (head != null)
            return 0; // head.prev;
        throw new IllegalArgumentException("underflow");
    }

    void removeFirst()
    {
        if (head == null)
            throw new IllegalArgumentException("underflow");

        // remove node (head)
    }

    void addLast(Object node)
    {
        // if (head == null)

        // node.list = this;
    }

    void removeLast()
    {
        if (head == null)
            throw new IllegalArgumentException("underflow");

        // removed node (head.prev);
    }
}
