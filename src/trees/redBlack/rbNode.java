package trees.redBlack;

public class RBNode {
    public enum Color {RED, BLACK}

    ;

    public RBNode parent;
    public RBNode left;
    public RBNode right;
    public Object payload;
    public Color color;
    public int key = -1;

    public String dumpTree(String prefix) {
        StringBuilder result = new StringBuilder();

        result.append(prefix);
        result.append(" -- ");
        if (key >= 0) {
            result.append(key);
            result.append(": ");
        }
        result.append(payload);
        if (color != null) {
            result.append(" ");
            result.append(color);
        }
        result.append('\n');

        if (left != null) {
            result.append(prefix);
            result.append(left.dumpTree(prefix + "   "));
        }

        if (right != null) {
            result.append(prefix);
            result.append(right.dumpTree(prefix + "   "));
        }

        return result.toString();
    }
}
