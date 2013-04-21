package heaps.binomial;

public class Node {
    public static final Node NIL = new Node();

    public int key;
    public int degree;
    public Node p = NIL;
    public Node sibling = NIL;
    public Node child = NIL;
}
