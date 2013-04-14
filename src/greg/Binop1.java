package greg;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public class Binop1<T> implements Callable<T> {

    final RunnableFuture<T> lopand;
    final RunnableFuture<T> ropand;
    final Op2<T> continuation;

    public Binop1(Callable<T> lopand, Callable<T> ropand, Op2<T> continuation) {
        this.lopand = new FutureTask<T>(lopand);
        this.ropand = new FutureTask<T>(ropand);
        this.continuation = continuation;
    }

    @Override
    public T call() throws Exception {
//        try {
//            if (!lopand.isDone())
//            {
//                if (!ropand.isDone())
//                    FutureTask<T> task = new FutureTask<T>(ropand);
//                lopand.run();
//            }
//            else if (!ropand.isDone())
//            {
//                ropand.run();
//            }
//
//            return continuation.op(lopand.get(), ropand.get());
//        } catch (InterruptedException e) {
//            continuation.setException(e);
//        } catch (ExecutionException e) {
//            continuation.setException(e);
//        }
//
        return null;
    }
}
