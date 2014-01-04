package book.paralleizing;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Warshall1Tests {
    @Test
    public void FirstTests() {
        final int size = 5000;
        final boolean[][] a = arraySetup(size);
        dumpArray(a);

        long start = System.nanoTime();
        Warshall1 warshall = new Warshall1(8);
        long mid = System.nanoTime();
        warshall.closure(a);
        long finish = System.nanoTime();

        dumpArray(a);
        for (int i = 0; i < a.length; i++)
            assertTrue(a[i][i]);

        System.out.println("Setup time = " + (mid - start) / 1.0e6 + " ms");
        System.out.println("Solved time = " + (finish - mid) / 1.0e9 + " s");
    }

    public static boolean[][] arraySetup(int size) {
        final boolean[][] a = new boolean[size][size];

        for (int i = 0; i < size - 1; i++)
            a[i][i + 1] = true;
        a[size - 1][0] = true;
        return a;
    }

    public static void dumpArray(boolean[][] a) {
        if (a.length >= 10)
            return;

        for (int i = 0; i < a.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < a[i].length - 1; j++)
                System.out.print(a[i][j] ? "t," : "f,");
            System.out.print(a[i][a[i].length - 1] ? "t" : "f");
            System.out.print(" ]");
            System.out.println();
        }
        System.out.println();
    }
}
