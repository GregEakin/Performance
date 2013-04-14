package greg;

import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/12/13
 * Time: 5:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Path2 {
    @Test
    public void main() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<Character> f1 = executor.submit(new Node('1'));
        Future<Character> f2 = executor.submit(new Node('2'));
        Future<Character> f3 = executor.submit(new Node('3'));
        Future<Character> f4 = executor.submit(new Node('4'));
        Future<Character> f5 = executor.submit(new BinaryNode('5', f1, f2));
        Future<Character> f6 = executor.submit(new BinaryNode('6', f3, f4));
        Future<Character> f7 = executor.submit(new BinaryNode('7', f5, f6));

        assertEquals('7', (char) f7.get());
        executor.shutdown();
        assertTrue(executor.awaitTermination(30L, TimeUnit.SECONDS));
    }

    private static class Node implements Callable<Character> {
        final char node;

        public Node(char node) {
            this.node = node;
        }

        @Override
        public Character call() throws Exception {
            System.out.println("Node " + Thread.currentThread().getName());
            for (int i = 0; i < 10; i++) {
                System.out.print(node);
                Thread.sleep(200);
            }
            if (node != '4' && node != '6' && node != '7') {
                System.out.println("Going to sleep " + node);
                Thread.sleep(20000);
            }
            System.out.println();

            return node;
        }
    }

    private static class BinaryNode implements Callable<Character> {
        final char node;
        final Future<Character> f1;
        final Future<Character> f2;

        public BinaryNode(char node, Future<Character> f1, Future<Character> f2) {
            this.node = node;
            this.f1 = f1;
            this.f2 = f2;
        }

        @Override
        public Character call() throws Exception {
            System.out.println("BinaryNode " + Thread.currentThread().getName());
            for (int i = 0; i < 10; i++) {
                System.out.print(node);
                Thread.sleep(200);
            }
            System.out.println();
            f1.get();
            f2.get();
            return node;
        }
    }
}