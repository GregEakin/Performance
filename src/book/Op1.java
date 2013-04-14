package book;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/11/13
 * Time: 8:54 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Op1<T> {
    public void op(T operand);
    public void setException(Throwable t);
}
