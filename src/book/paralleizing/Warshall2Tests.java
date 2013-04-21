package book.paralleizing;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Warshall2Tests {
    @Test
    public void FirstTests() {
        final int size = 5000;
        final boolean[][] a = Warshall1Tests.arraySetup(size);
        Warshall1Tests.dumpArray(a);

        long start = System.nanoTime();
        Warshall2 warshall = new Warshall2(8);
        long mid = System.nanoTime();
        warshall.closure(a);
        long finish = System.nanoTime();

        Warshall1Tests.dumpArray(a);
        for (int i = 0; i < a.length; i++)
            assertTrue(a[i][i]);

        System.out.println("Setup time = " + (mid - start) / 1.0e6 + " ms");
        System.out.println("Solved time = " + (finish - mid) / 1.0e9 + " s");
    }
}
