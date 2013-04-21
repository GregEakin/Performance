package heaps.binomial;

public class Heap {
    public Node head = Node.NIL;

    public Node Minimum() {
        Node y = Node.NIL;
        Node x = head;
        int min = Integer.MAX_VALUE;
        while (x != Node.NIL) {
            if (x.key < min) {
                min = x.key;
                y = x;
            }
            x = x.sibling;
        }
        return y;
    }

    public static void Link(Node y, Node z) {
        y.p = z;
        y.sibling = z.child;
        z.child = y;
        z.degree++;
    }

    public static Heap Union(Heap h1, Heap h2) {
        Heap h = new Heap();
        h.head = Merge(h1, h2);
        if (h.head == Node.NIL)
            return h;
        Node prevX = Node.NIL;
        Node x = h.head;
        Node nextX = x.sibling;
        while (nextX != Node.NIL) {
            if ((x.degree != nextX.degree) || (x.sibling != Node.NIL && nextX.sibling.degree == x.degree)) {
                prevX = x;
                x = nextX;
            } else if (x.key <= nextX.key) {
                x.sibling = nextX.sibling;
                Link(nextX, x);
            } else {
                if (prevX == Node.NIL)
                    h.head = nextX;
                else
                    prevX.sibling = nextX;
                Link(x, nextX);
                x = nextX;
            }
            nextX = x.sibling;
        }
        return h;
    }

    public void Insert(Node x)
    {
        Heap h = new Heap();
        h.head = x;
        Union(this, h);
    }

    private static Node Merge(Heap h1, Heap h2) {
        return Node.NIL;
    }

    public Node ExtractMin()
    {
        Node x = Node.NIL;

        // find the root w/ min key, in the root list of H
        //  and remove x from the root list of H
        Heap h = new Heap();
        // reverse the order of the liked list of x's children
        //  and set h.head to point the head of the resulting list
        Union(this, h);
        return x;
    }
}
