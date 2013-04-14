package book;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/11/13
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Binop2<T> implements StoreOp<T> {
    T lopand;
    T ropand;
    Op2<T> continuation;
    int needed = 2;

    public Binop2(Op2 continuation)
    {
        this.continuation = continuation;
    }

    @Override
    public void store(int i, T value) {
        if (i == 0) lopand = value;
        else ropand = value;
        if (--needed == 0) continuation.op(lopand, ropand);
    }

    @Override
    public void setException(Throwable t) {
        continuation.setException(t);
    }
}
