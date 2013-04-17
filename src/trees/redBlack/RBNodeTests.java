package trees.redBlack;

import org.approvaltests.Approvals;
import org.junit.Test;

import static org.junit.Assert.*;

public class RBNodeTests {
    @Test
    public void DumpTreeTest() throws Exception {
        RBNode x = buildSimpleTree();
        Approvals.verify(x.dumpTree(""));
    }

    public static RBNode buildSimpleTree() {
        RBNode x = new RBNode();
        x.payload = "x";

        RBNode alpha = new RBNode();
        alpha.payload = "α";
        x.left = alpha;
        alpha.parent = x;

        RBNode y = new RBNode();
        y.payload = "y";
        x.right = y;
        y.parent = x;

        RBNode beta = new RBNode();
        beta.payload = "β";
        y.left = beta;
        beta.parent = y;

        RBNode gamma = new RBNode();
        gamma.payload = "γ";
        y.right = gamma;
        gamma.parent = y;

        return x;
    }
}
