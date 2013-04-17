package trees.redBlack;

public class RBTree {
    RBNode root;

    public void LeftRotate(RBNode x) {
        RBNode y = x.right;
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    @Override
    public String toString() {
        return root.dumpTree("");
    }
}
