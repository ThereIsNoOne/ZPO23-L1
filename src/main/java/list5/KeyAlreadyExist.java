package list5;

/**
 * Exception representing already existing key, when adding to
 * map.
 */
public class KeyAlreadyExist extends RuntimeException {

    /**
     * Initialize the exception
     * @param message message
     */
    public KeyAlreadyExist(String message) {
        super(message);
    }
}
