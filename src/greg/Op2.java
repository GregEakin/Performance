package greg;

/**
 * Created with IntelliJ IDEA.
 * User: greg.eakin
 * Date: 4/12/13
 * Time: 2:08 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Op2<T> {
    public T call(T lopand, T ropand) throws Exception;
}
