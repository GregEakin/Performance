package greg;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/12/13
 * Time: 2:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class Vadd1 implements Callable<double[]> {
    final double[] lopand;
    final double[] ropand;

    Vadd1(double[] loperand, double[] roperand) {
        this.lopand = loperand;
        this.ropand = roperand;
    }

    @Override
    public double[] call() throws Exception {
        double[] x = lopand;
        double[] y = ropand;
        double[] z = new double[x.length];
        for (int i = 0; i < z.length; i++)
            z[i] = x[i] + y[i];
        return z;
    }
}
