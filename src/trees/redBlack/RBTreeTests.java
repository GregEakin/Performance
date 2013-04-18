package trees.redBlack;

import org.approvaltests.Approvals;
import org.junit.Test;

import static org.junit.Assert.*;

public class RBTreeTests {

    @Test
    public void LeftRotateRootTest() throws Exception {
        RBTree tree = new RBTree();
        tree.root = RBNodeTests.buildSimpleTree();

        tree.LeftRotate(tree.root);
        Approvals.verify(tree.root.dumpTree(""));
    }

    @Test
    public void LeftRotateNodeTest() throws Exception {
        RBTree tree = new RBTree();
        tree.root = new RBNode();
        tree.root.payload = "root";
        tree.root.right = RBNodeTests.buildSimpleTree();
        tree.root.right.parent = tree.root;

        tree.LeftRotate(tree.root.right);
        Approvals.verify(tree.root.dumpTree(""));
    }

    @Test
    public void RightRotateRootTest() throws Exception {
        RBTree tree = new RBTree();
        tree.root = RBNodeTests.buildSimpleTree();

        tree.LeftRotate(tree.root);
        tree.RightRotate(tree.root);
        Approvals.verify(tree.root.dumpTree(""));
    }

    @Test
    public void Insert() throws Exception {
        RBTree tree = new RBTree();
        tree.root = new RBNode();
        tree.root.payload = "11";
        tree.root.key = -1;
        tree.root.color = RBNode.Color.BLACK;

        int[] values = new int[]{14, 15};
        for (int i : values) {
            RBNode node = new RBNode();
            node.payload = "" + i;
            node.key = i;
            tree.Insert(node);
        }

        Approvals.verify(tree.root.dumpTree(""));
    }
}
