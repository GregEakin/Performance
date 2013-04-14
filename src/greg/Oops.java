package greg;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/12/13
 * Time: 4:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class Oops {
    @Test
    public void main() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            }
        };

        Future<double[]> x = executor.submit(new Callable<double[]>() {
            @Override
            public double[] call() throws Exception {
                System.out.println("x.Call");
                for (int i = 0; i < 10; i++) {
                    System.out.print("x");
                    Thread.sleep(200);
                }
                System.out.println();
                return new double[]{1.0, 2.0, 3.0};
            }
        });

        Future<double[]> y = executor.submit(new Callable<double[]>() {
            @Override
            public double[] call() throws Exception {
                System.out.println("y.Call");
                for (int i = 0; i < 10; i++) {
                    System.out.print("y");
                    Thread.sleep(200);
                }
                System.out.println();
                return new double[]{4.0, 5.0, 6.0};
            }
        });

        Future<double[]> future = executor.submit(new Vadd(x, y));

        assertArrayEquals(new double[]{5.0, 7.0, 9.0}, future.get(), 1e-6);
    }
}
