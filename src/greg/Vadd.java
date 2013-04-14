package greg;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/12/13
 * Time: 2:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class Vadd implements Callable<double[]> {
    final Future<double[]> lopand;
    final Future<double[]> ropand;

    Vadd(Future<double[]> loperand, Future<double[]> roperand) {
        this.lopand = loperand;
        this.ropand = roperand;
    }

    @Override
    public double[] call() throws Exception {
        System.out.println("Vadd.Call");
        for (int i = 0; i < 10; i++)
        {
            System.out.print("v");
            Thread.sleep(2000);
        }
        System.out.println();

        double[] x = lopand.get();
        double[] y = ropand.get();
        double[] z = new double[x.length];
        for (int i = 0; i < z.length; i++)
            z[i] = x[i] + y[i];
        return z;
    }
}
