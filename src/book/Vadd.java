package book;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/11/13
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class Vadd implements Op2<double[]> {
    final Op1<double[]> continuation;

    Vadd(Op1<double[]> contin) {
        this.continuation = contin;
    }

    @Override
    public void op(double[] lopand, double[] ropand) {
        try {
            double[] x = lopand;
            double[] y = ropand;
            double[] z = new double[x.length];
            for (int i = 0; i < z.length; i++)
                z[i] = x[i] + y[i];
            continuation.op(z);
        } catch (Exception e) {
            continuation.setException(e);
        }
    }

    @Override
    public void setException(Throwable t) {
        continuation.setException(t);
    }
}
