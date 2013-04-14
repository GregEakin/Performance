package greg;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/12/13
 * Time: 1:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestVadd1 {
    @Test
    public void main() throws InterruptedException, ExecutionException {
//        DFFuture1<double[]> f1 = new DFFuture1<double[]>(new Callable<double[]>() {
//            @Override
//            public double[] call() throws Exception {
//                return new double[]{1.0, 2.0, 3.0};
//            }
//        });
//        DFFuture1<double[]> f2 = new DFFuture1<double[]>(new Callable<double[]>() {
//            @Override
//            public double[] call() throws Exception {
//                return new double[]{4.0, 5.0, 6.0};
//            }
//        });
//        DFFuture1<double[]> f3 = new DFFuture1<double[]>(new Vadd());
//
//        Binop1<double[]> binop1 = new Binop1<double[]>(f1, f2, new Vadd(f3));
//        DFFuture1<double[]> oops = new DFFuture1<double[]>(binop1);
//
//        f1.run();
//        f2.run();
//        double[] z = f3.get();
//        Assert.assertEquals(new double[]{5.0, 7.0, 9.0}, z);
    }
}
