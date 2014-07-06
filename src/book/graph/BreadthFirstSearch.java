package book.graph;

import org.junit.Test;
import structures.Queue;

import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;

import static org.junit.Assert.assertEquals;

public class BreadthFirstSearch {
    @Test
    public void Figure23() {
        UndirectedGraph.Pair[] data = new UndirectedGraph.Pair[]{
                new UndirectedGraph.Pair('r', 'v'),
                new UndirectedGraph.Pair('r', 's'),
                new UndirectedGraph.Pair('s', 'w'),
                new UndirectedGraph.Pair('w', 't'),
                new UndirectedGraph.Pair('w', 'x'),
                new UndirectedGraph.Pair('t', 'x'),
                new UndirectedGraph.Pair('t', 'u'),
                new UndirectedGraph.Pair('x', 'y'),
                new UndirectedGraph.Pair('u', 'y'),
        };

        UndirectedGraph graph = new UndirectedGraph(data);
        Dictionary<Character, Element> edges = Search(graph, 's');
        for (Element element : Collections.list(edges.elements())) {
            System.out.print(element.c + ": ");
            System.out.print(" d = " + element.d);
            assertEquals(Element.States.Black, element.color);
            System.out.println();
        }
    }

    public Dictionary<Character, Element> Search(UndirectedGraph<Character> graph, Character node) {
        Element root = null;
        final Dictionary<Character, Element> edges = new Hashtable<Character, Element>();
        for (Character key : Collections.list(graph.edges.keys())) {
            Element element = new Element();
            element.c = key;
            element.edge = graph.edges.get(key);
            element.color = Element.States.White;
            element.d = Integer.MAX_VALUE;
            element.pi = null;
            edges.put(key, element);

            if (key == node)
                root = element;
        }

        if (root != null) {
            root.color = Element.States.Gray;
            root.d = 0;
            root.pi = null;

            Queue<Element> queue = new Queue<Element>(100);
            queue.enqueue(root);
            while (!queue.empty()) {
                Element u = queue.dequeue();
                Edge edge = u.edge;
                while (edge.next != null) {
                    edge = edge.next;
                    Element v = edges.get(edge.value);
                    if (v.color == Element.States.White) {
                        v.color = Element.States.Gray;
                        v.d = u.d + 1;
                        v.pi = u;
                        queue.enqueue(v);
                    }
                }
                u.color = Element.States.Black;
            }
        }
        return edges;
    }

    static class Element {
        public Edge<Character> edge;
        public States color;
        public int d;
        public Element pi;
        Character c;

        enum States {White, Gray, Black}
    }
}
