package book.graph;

import java.util.LinkedList;

public class Vertex {
    final public Edge edge;
    final public LinkedList<Edge> list = new LinkedList<Edge>();

    public Vertex(Edge edge) {
        this.edge = edge;
    }
}
