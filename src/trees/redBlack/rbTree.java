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

    public void RightRotate(RBNode y) {
        RBNode x = y.left;
        y.left = x.right;
        if (x.right != null)
            x.right.parent = y;
        x.parent = y.parent;
        if (y.parent == null)
            root = x;
        else if (y == y.parent.right)
            y.parent.right = x;
        else
            y.parent.left = x;
        x.right = y;
        y.parent = x;
    }

    public void Insert(RBNode x) {
        TreeInsert(x);
        x.color = RBNode.Color.RED;
        while (x != root && x.parent.color == RBNode.Color.RED) {
            if (x.parent == x.parent.parent.left) {
                RBNode y = x.parent.parent.right;
                if (y.color == RBNode.Color.RED)
                {
                    x.parent.color = RBNode.Color.BLACK;
                    y.color = RBNode.Color.BLACK;
                    x.parent.parent.color = RBNode.Color.RED;
                    x = x.parent.parent;
                }
                else
                {
                    if (x == x.parent.right)
                    {
                        x = x.parent;
                        LeftRotate(x);
                    }
                    x.parent.color = RBNode.Color.BLACK;
                    x.parent.parent.color = RBNode.Color.RED;
                    RightRotate(x.parent.parent);
                }
            } else {
                RBNode y = x.parent.parent.left;
                if (y.color == RBNode.Color.RED)
                {
                    x.parent.color = RBNode.Color.BLACK;
                    y.color = RBNode.Color.BLACK;
                    x.parent.parent.color = RBNode.Color.RED;
                    x = x.parent.parent;
                }
                else
                {
                    if (x == x.parent.left)
                    {
                        x = x.parent;
                        RightRotate(x);
                    }
                    x.parent.color = RBNode.Color.BLACK;
                    x.parent.parent.color = RBNode.Color.RED;
                    LeftRotate(x.parent.parent);
                }
            }
        }
        root.color = RBNode.Color.BLACK;
    }

    public void TreeInsert(RBNode z) {
        RBNode y = null;
        RBNode x = root;
        while (x != null) {
            y = x;
            if (z.key < x.key)
                x = x.left;
            else
                x = x.right;
        }
        z.parent = y;
        if (y == null)
            root = z;
        else if (z.key < y.key)
            y.left = z;
        else
            y.right = z;
    }

    @Override
    public String toString() {
        return root.dumpTree("");
    }
}
