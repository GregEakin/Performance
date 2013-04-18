package greg;

import junit.framework.Assert;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/12/13
 * Time: 5:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Path {
    // @Test
    public void main() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<Character> future = null;
        for (int i = 1; i < 8; i++)
        {
            char i1 = (char)(i + 48);
            future = executor.submit(new Node(i1));
        }

        Assert.assertEquals('7', (char)future.get());
    }

    private static class Node implements Callable<Character> {
        final char node;

        public Node(char node) {
            this.node = node;
        }

        @Override
        public Character call() throws Exception {
            System.out.println("Node ");
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
}