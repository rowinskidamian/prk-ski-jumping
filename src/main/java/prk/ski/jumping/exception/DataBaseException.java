package prk.ski.jumping.exception;

/**
 * @author DamianRowinski
 */

public class DataBaseException extends Exception {
    public static final long serialVersionUID = 1L;
    public DataBaseException (String message) {
        super(message);
    }
}
