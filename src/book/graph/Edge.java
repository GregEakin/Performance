package book.graph;

import java.util.LinkedList;

public class Edge {
    final public int value;
    public Edge next;

    public Edge(int value) {
        this.value = value;
    }

    public void append(Edge item) {
        Edge edge = this;
        while(edge.next != null)
            edge = edge.next;
        edge.next = item;
    }
}
