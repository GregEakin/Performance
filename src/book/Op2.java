package book;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/11/13
 * Time: 8:55 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Op2<T> {
    public void op(T lopand, T ropand);
    public void setException(Throwable t);
}
