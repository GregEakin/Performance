package trees.redBlack;

public class RBNode {
    public RBNode parent;
    public RBNode left;
    public RBNode right;
    public Object payload;

    public String dumpTree(String prefix) {
        StringBuilder result = new StringBuilder();

        result.append(prefix);
        result.append(" -- ");
        result.append(payload);
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
