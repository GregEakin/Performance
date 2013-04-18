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
    public void TreeInsertTest() throws Exception {
        RBTree tree = new RBTree();

        int[] values = new int[]{14, 16, 7, 15, 17, 6, 8, 14};
        for (int i : values) {
            RBNode node = new RBNode();
            node.payload = "" + i;
            node.key = i;
            tree.TreeInsert(node);
        }

        Approvals.verify(tree.root.dumpTree(""));
    }

    @Test
    public void InsertTest() throws Exception {
        RBTree tree = new RBTree();

        int[] values = new int[]{11, 14, 2, 15, 1, 7, 5, 8, 4};
        for (int i : values) {
            RBNode node = new RBNode();
            node.payload = "" + i;
            node.key = i;
            tree.Insert(node);
        }

        Approvals.verify(tree.root.dumpTree(""));
    }
}
