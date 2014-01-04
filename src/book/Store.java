package book;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/11/13
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Store<T> implements Op1<T> {
    StoreOp<T> dst;
    int pos;

    public Store(StoreOp<T> dst, int pos) {
        this.dst = dst;
        this.pos = pos;
    }

    @Override
    public void op(T operand) {
        dst.store(pos, operand);
    }

    @Override
    public void setException(Throwable t) {
        dst.setException(t);
    }
}
