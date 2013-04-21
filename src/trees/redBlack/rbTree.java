package trees.redBlack;

public class RBTree {
    private final RBNode nil = new RBNode();
    public RBNode root;

    public RBTree() {
        nil.color = RBNode.Color.BLACK;
    }

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
                if (y != null && y.color == RBNode.Color.RED) {
                    x.parent.color = RBNode.Color.BLACK;
                    y.color = RBNode.Color.BLACK;
                    x.parent.parent.color = RBNode.Color.RED;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.right) {
                        x = x.parent;
                        LeftRotate(x);
                    }
                    x.parent.color = RBNode.Color.BLACK;
                    x.parent.parent.color = RBNode.Color.RED;
                    RightRotate(x.parent.parent);
                }
            } else {
                RBNode y = x.parent.parent.left;
                if (y != null && y.color == RBNode.Color.RED) {
                    x.parent.color = RBNode.Color.BLACK;
                    y.color = RBNode.Color.BLACK;
                    x.parent.parent.color = RBNode.Color.RED;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.left) {
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

    public void RBInsert(RBNode z) {
        RBNode y = nil;
        RBNode x = root;
        while (x != nil) {
            y = x;
            x = z.key < x.key ? x.left : x.right;
        }
        z.parent = y;
        if (y == nil)
            root = z;
        else if (z.key < y.key)
            y.left = z;
        else
            y.right = z;
        z.left = nil;
        z.right = nil;
        z.color = RBNode.Color.RED;
        InsertFixUp(z);
    }

    public void InsertFixUp(RBNode z) {
        while (z.parent.color == RBNode.Color.RED) {
            if (z.parent == z.parent.parent.left) {
                RBNode y = z.parent.parent.right;
                if (y.color == RBNode.Color.RED) {
                    z.parent.color = RBNode.Color.BLACK;
                    y.color = RBNode.Color.BLACK;
                    z.parent.parent.color = RBNode.Color.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        LeftRotate(z);
                    }
                    z.parent.color = RBNode.Color.BLACK;
                    z.parent.parent.color = RBNode.Color.RED;
                    RightRotate(z.parent.parent);
                }
            } else {
                RBNode y = z.parent.parent.left;
                if (y.color == RBNode.Color.RED) {
                    z.parent.color = RBNode.Color.BLACK;
                    y.color = RBNode.Color.BLACK;
                    z.parent.parent.color = RBNode.Color.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        RightRotate(z);
                    }
                    z.parent.color = RBNode.Color.BLACK;
                    z.parent.parent.color = RBNode.Color.RED;
                    LeftRotate(z.parent.parent);
                }
            }
        }
    }

    // Pull up
    public RBNode Search(RBNode x, int k) {
        while (x != null && k != x.key) {
            x = k < x.key ? x.left : x.right;
        }
        return x;
    }

    // Pull up
    public RBNode Minimum(RBNode x) {
        while (x.left != null)
            x = x.left;
        return x;
    }

    // pull up
    public RBNode Maximum(RBNode x) {
        while (x.right != null)
            x = x.right;
        return x;
    }

    // Pull up
    public RBNode Successor(RBNode x) {
        if (x.right != null)
            return Minimum(x.right);
        RBNode y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    public void Delete(RBNode z) {
        RBNode y = z.left == null || z.right == null ? z : Successor(z);
        RBNode x = y.left != null ? y.left : y.right;
        x.parent = y.parent;
        if (y.parent == null)
            root = x;
        else {
            if (y == y.parent.left)
                y.parent.left = x;
            else
                y.parent.right = x;
        }
        if (y != z) {
            z.key = y.key;
            z.payload = y.payload;
        }
        if (y.color == RBNode.Color.BLACK)
            DeleteFixUp(x);
    }

    private void DeleteFixUp(RBNode x) {
        while (x != null && x.color == RBNode.Color.BLACK) {
            if (x == x.left.parent) {
                RBNode w = x.parent.right;
                if (w.color == RBNode.Color.RED) {
                    w.color = RBNode.Color.BLACK;
                    x.parent.color = RBNode.Color.RED;
                    LeftRotate(x.parent);
                    w = x.parent.right;
                }
                if (w.left.color == RBNode.Color.BLACK && w.right.color == RBNode.Color.BLACK) {
                    w.color = RBNode.Color.RED;
                    x = x.parent;
                } else {
                    if (w.right.color == RBNode.Color.BLACK) {
                        w.left.color = RBNode.Color.BLACK;
                        w.color = RBNode.Color.RED;
                        RightRotate(w);
                        w = w.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = RBNode.Color.BLACK;
                    w.right.color = RBNode.Color.BLACK;
                    LeftRotate(x.parent);
                    x = root;
                }
            } else {
                RBNode w = x.parent.left;
                if (w.color == RBNode.Color.RED) {
                    w.color = RBNode.Color.BLACK;
                    x.parent.color = RBNode.Color.RED;
                    RightRotate(x.parent);
                    w = x.parent.left;
                }
                if (w.right.color == RBNode.Color.BLACK && w.left.color == RBNode.Color.BLACK) {
                    w.color = RBNode.Color.RED;
                    x = x.parent;
                } else {
                    if (w.left.color == RBNode.Color.BLACK) {
                        w.right.color = RBNode.Color.BLACK;
                        w.color = RBNode.Color.RED;
                        LeftRotate(w);
                        w = w.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = RBNode.Color.BLACK;
                    w.left.color = RBNode.Color.BLACK;
                    RightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = RBNode.Color.BLACK;
    }

    // pull up
    public RBNode TreeDelete(RBNode z) {
        RBNode y = z.left == null || z.right == null ? z : Successor(z);
        RBNode x = y.left != null ? y.left : y.right;
        if (x != null)
            x.parent = y.parent;
        if (y.parent == null)
            root = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;
        if (y != z) {
            z.key = y.key;
            z.payload = y.payload;
        }
        return y;
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
