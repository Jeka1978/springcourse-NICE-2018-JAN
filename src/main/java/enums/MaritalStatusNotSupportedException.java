package enums;

/**
 * @author Evgeny Borisov
 */
public class MaritalStatusNotSupportedException extends UnsupportedOperationException {
    public MaritalStatusNotSupportedException(String message) {
        super(message);
    }
}
