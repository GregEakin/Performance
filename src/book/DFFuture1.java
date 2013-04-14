package book;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/11/13
 * Time: 10:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class DFFuture1<T> extends FutureTask<T> implements Op1<T> {

    public DFFuture1(Callable<T> callable) {
        super(callable);
    }

    public DFFuture1(Runnable runnable, T result) {
        super(runnable, result);
    }

    public void op(T opand) {
        set(opand);
    }

    public void setException(Throwable t) {
        super.setException(t);
    }
}
