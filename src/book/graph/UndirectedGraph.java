package book.graph;

import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;

public class UndirectedGraph {
    final Dictionary<Integer, Edge> edges = new Hashtable<Integer, Edge>();

    public UndirectedGraph(int size) {
        for (int i = 0; i < size; i++)
            edges.put(i + 1, new Edge(i + 1));
    }

    public UndirectedGraph(Pair[] data) {
        for (Pair pair : data) {
            Edge edge1 = edges.get(pair.x);
            if (edge1 == null) {
                edge1 = new Edge(pair.x);
                edges.put(pair.x, edge1);
            }
            edge1.append(new Edge(pair.y));

            Edge edge2 = edges.get(pair.y);
            if (edge2 == null) {
                edge2 = new Edge(pair.y);
                edges.put(pair.y, edge2);
            }
            edge2.append(new Edge(pair.x));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Edge edge : Collections.list(edges.elements())) {
            result.append(edge.value);
            while (edge.next != null) {
                edge = edge.next;
                result.append(" -> ");
                result.append(edge.value);
            }
            result.append(" /\n");
        }
        return result.toString();
    }

    public static class Pair {
        final int x;
        final int y;

        public Pair(int x, int y) {
            if (x < y) {
                this.x = x;
                this.y = y;
            } else {
                this.x = y;
                this.y = x;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (obj == this)
                return true;
            if (!(obj instanceof Pair))
                return false;

            Pair pair = (Pair) obj;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return x + y * 1003;
        }
    }
}
