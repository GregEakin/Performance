package heaps.leftist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Greg on 7/5/2014.
 */
public class Heap {
    private Node array = null;

    public Heap(int[] array) {
        Queue<Node> queue = new LinkedList<>();
        for(int element : array)
        {
            Node node = new Node();
            node.element = element;
            queue.add(node);
        }

        while(!queue.isEmpty())
        {
            Node left = queue.remove();
            if (queue.isEmpty())
            {
                this.array = left;
                break;
            }
            Node right = queue.remove();
            Node result = merge(left, right);
            queue.add(result);
        }
    }

    public Node merge(Node x, Node y) {
        if(x == null)
            return y;
        if(y == null)
            return x;

        // if this was a max height biased leftist tree, then the
        // next line would be: if(x.element < y.element)
        if(x.element.compareTo(y.element) > 0) {
            Node temp = x;
            x = y;
            y = temp;
        }

        x.rightChild = merge(x.rightChild, y);

        if(x.leftChild == null) {
            // left child doesn't exist, so move right child to the left side
            x.leftChild = x.rightChild;
            x.rightChild = null;

        } else {
            // left child does exist, so compare s-values
            if(x.leftChild.s < x.rightChild.s) {
                Node temp = x.leftChild;
                x.leftChild = x.rightChild;
                x.rightChild = temp;
            }
            // since we know the right child has the lower s-value, we can just
            // add one to its s-value
            x.s = x.rightChild.s + 1;
        }
        return x;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node node = this.array;
        if (node != null)
        {
            result.append(dumpNode(node));
        }
        result.append("\n");
        return result.toString();
    }

    private String dumpNode(Node node)
    {
        if (node == null)
            return "<null>";

        StringBuilder result = new StringBuilder();
            result.append(node.element);
            result.append(" (");
            result.append(node.s);
            result.append(") ");
            if (node.leftChild != null)
            {
                result.append(" L:{");
                result.append(dumpNode(node.leftChild));
                result.append("} ");
            }
            if (node.rightChild!= null)
            {
                result.append(" R:{");
                result.append(dumpNode(node.rightChild));
                result.append("} ");
            }
        return result.toString();
    }
}
