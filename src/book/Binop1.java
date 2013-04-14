package book;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;

public class Binop1<T> implements Callable<T> {

    final RunnableFuture<T> lopand;
    final RunnableFuture<T> ropand;
    final Op2<T> continuation;

    public Binop1(RunnableFuture<T> lopand, RunnableFuture<T> ropand, Op2<T> continuation) {
        this.lopand = lopand;
        this.ropand = ropand;
        this.continuation = continuation;
    }

    @Override
    public T call() throws Exception {
        try {
            if (!lopand.isDone()) {
                lopand.run();
                return null;
            }
            if (!ropand.isDone()) {
                ropand.run();
                return null;
            }
            continuation.op(lopand.get(), ropand.get());
        } catch (InterruptedException e) {
            continuation.setException(e);
        } catch (ExecutionException e) {
            continuation.setException(e);
        }

        return null;
    }
}
