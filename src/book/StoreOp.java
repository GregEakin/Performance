package book;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/11/13
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StoreOp<T> {
    public void store(int i, T value);

    public void setException(Throwable t);
}
