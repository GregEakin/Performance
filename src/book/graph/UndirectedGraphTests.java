package book.graph;

import org.junit.Test;

public class UndirectedGraphTests {
    @Test
    public void Figure1a() {
        UndirectedGraph.Pair[] data = new UndirectedGraph.Pair[]{
                new UndirectedGraph.Pair(1, 2),
                new UndirectedGraph.Pair(1, 5),
                new UndirectedGraph.Pair(2, 3),
                new UndirectedGraph.Pair(2, 4),
                new UndirectedGraph.Pair(2, 5),
                new UndirectedGraph.Pair(3, 4),
                new UndirectedGraph.Pair(4, 5),
        };

        UndirectedGraph graph = new UndirectedGraph(data);

        System.out.println(graph.toString());
    }
}
