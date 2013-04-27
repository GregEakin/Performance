package book.graph;

import org.junit.Test;

public class EdgeTests {

    private static void ShowAdjacencyList(Edge[] edges) {
     }

    @Test
    public void Figure2a() {
        Pair[] data = new Pair[]{
                new Pair(1, 2),
                new Pair(1, 4),
                new Pair(2, 5),
                new Pair(3, 5),
                new Pair(3, 6),
                new Pair(4, 2),
                new Pair(5, 4),
                new Pair(6, 6),
        };

        Edge[] edges = new Edge[6];
        for (int i = 0; i < edges.length; i++)
            edges[i] = new Edge(i + 1);

        for (Pair pair : data) {
            edges[pair.x - 1].append(new Edge(pair.y));
            //edges[pair.y - 1].append(new Edge(pair.x));
        }

        ShowAdjacencyList(edges);
    }
}
