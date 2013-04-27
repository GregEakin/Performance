package book.graph;

import java.util.LinkedList;

public class Edge<T> {
    final public T value;
    public Edge next;

    public Edge(T value) {
        this.value = value;
    }

    public void append(Edge item) {
        Edge edge = this;
        while(edge.next != null)
            edge = edge.next;
        edge.next = item;
    }
}
