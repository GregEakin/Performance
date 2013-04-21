package heaps.fibonacci;

public class Node {
    public final static Node NIL = new Node();

    public int key;
    public int degree;
    public Node p = NIL;
    public Node child = NIL;
    public Node left = NIL;
    public Node right = NIL;
    public boolean mark;

}
