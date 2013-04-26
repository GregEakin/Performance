package book.graph;

import org.junit.Test;

public class EdgeTests {

    private static void ShowAdjacencyList(Edge[] edges) {
     }

    @Test
    public void Figure1() {
        Edge[] edges = new Edge[5];
        edges[0] = new Edge(1);
        edges[0].next = new Edge(2);
        edges[0].next.next = new Edge(5);
        edges[1] = new Edge(2);
        edges[1].next = new Edge(1);
        edges[1].next.next = new Edge(5);
        edges[1].next.next.next = new Edge(3);
        edges[1].next.next.next.next = new Edge(4);
        edges[2] = new Edge(3);
        edges[2].next = new Edge(2);
        edges[2].next.next = new Edge(4);
        edges[3] = new Edge(4);
        edges[3].next = new Edge(2);
        edges[3].next.next = new Edge(5);
        edges[3].next.next.next = new Edge(3);
        edges[4] = new Edge(5);
        edges[4].next = new Edge(4);
        edges[4].next.next = new Edge(1);
        edges[4].next.next.next = new Edge(2);

        ShowAdjacencyList(edges);
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
