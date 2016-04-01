package book.graph;

import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;

class UndirectedGraph<T> {
    final Dictionary<T, Edge<T>> edges = new Hashtable<>();

    UndirectedGraph(Pair<T>[] data) {
        for (Pair<T> pair : data) {
            Edge<T> edge1 = edges.get(pair.x);
            if (edge1 == null) {
                edge1 = new Edge<>(pair.x);
                edges.put(pair.x, edge1);
            }
            edge1.append(new Edge<>(pair.y));

            Edge<T> edge2 = edges.get(pair.y);
            if (edge2 == null) {
                edge2 = new Edge<>(pair.y);
                edges.put(pair.y, edge2);
            }
            edge2.append(new Edge<>(pair.x));
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
            result.append("\n");
        }
        return result.toString();
    }

    static class Pair<T> {
        final T x;
        final T y;

        Pair(T x, T y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (obj == this)
                return true;
            if (!(obj instanceof Pair))
                return false;

            Pair<?> pair = (Pair<?>) obj;
            return (x == pair.x && y == pair.y) || (x == pair.y && y == pair.x);
        }

        @Override
        public int hashCode() {
            return x.hashCode() + y.hashCode() * 1003;
        }
    }
}
