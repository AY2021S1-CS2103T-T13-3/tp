package seedu.address.model.session.exceptions;

/**
 * Signals that the operation will result in duplicate Sessions (Sessions are considered duplicates if they have the same
 * id).
 */
public class DuplicateSessionException extends RuntimeException {
    public DuplicateSessionException() {
        super("Operation would result in duplicate Sessions");
    }
}
