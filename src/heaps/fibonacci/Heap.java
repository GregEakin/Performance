package heaps.fibonacci;

public class Heap {
    private Node root = Node.NIL;
    private Node min = Node.NIL;
    private int n;

    public void Insert(Node x) {
        x.degree = 0;
        x.p = Node.NIL;
        x.child = Node.NIL;
        x.left = Node.NIL;
        x.right = Node.NIL;
        x.mark = false;

        if (root == Node.NIL)
            root = x;
        else {
            x.right = root;
            root.left = x;
            root = x;
        }
        if (min == Node.NIL || x.key < min.key)
            min = x;
        n++;
    }

    public static Heap Union(Heap h1, Heap h2) {
        Heap h = new Heap();
        h.min = h1.min;
        h.root = h1.root; // + h2.root
        if ((h1.min == Node.NIL) || (h2.min != Node.NIL && h2.min.key < h1.min.key))
            h.min = h2.min;
        h.n = h1.n + h2.n;
        return h;
    }

    public Node ExtractMin() {
        Node z = min;
        if (z != Node.NIL) {
            // remove z from root list
            // for each child of z
            {

                // add x to the root list of this
                // x.p = NIL;
            }
            if (z == z.right)
                min = Node.NIL;
            else {
                min = z.right;
                Consolidate();
            }
            n--;
        }
        return z;
    }

    private Node a[];
    private int d[];

    private void Consolidate() {
        for (int i = 0; i < d[n]; i++)
            a[i] = Node.NIL;
        // for each node w, in the root list of H
        {
            Node x = null; // w;
            int d = x.degree;
            while (a[d] != Node.NIL) {
                Node y = a[d];
                if (x.key > y.key)
                    ; // exchange x and y
                Link(y, x);
                a[d] = Node.NIL;
                d++;
            }
            a[d] = x;
        }
        min = Node.NIL;
        for (int i = 0; i < d[n]; i++) {
            if (a[i] != Node.NIL) {
                ; // add a[i] to the root list of H
                if (min == Node.NIL || a[i].key < min.key)
                    min = a[i];
            }
        }
    }

    private void Link(Node y, Node x) {

        // remove y from the root list
        // make y a child of x, incrementing x.degree
        // y.mark = false;
    }
}
