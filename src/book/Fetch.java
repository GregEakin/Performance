package book;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/11/13
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Fetch<T> implements Runnable {
    RunnableFuture<T> src;
    Op1 continuation;

    public Fetch(RunnableFuture<T> src, Op1 continuation) {
        this.src = src;
        this.continuation = continuation;
    }

    @Override
    public void run() {
        try {
            if (!src.isDone())
                src.run();
            continuation.op(src.get());
        }
        catch(InterruptedException e) {
            continuation.setException(e);
        } catch (ExecutionException e) {
            continuation.setException(e);
        }
    }
}
