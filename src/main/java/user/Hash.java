package src.main.java.user;
/**
 * Hash class for sensitive information.
 * @author Lester Lee
 * @version 1.0
 * @since 2022-11-01
 */
public class Hash {

    /**
     * Default constructor for Hash class.
     */
    // constructor
    public Hash() {
    };

    /**
     * Returns the hashed password to the external class.
     * @param password the password input by user.
     * @return hashed password.
     */
    // Hash Function
    public long HashPassword(String password) {
        return HashFunction(password);
    }

    /**
     * Hash function. Returns the hashed password to public function.
     * @param password the password input by user.
     * @return hashed password.
     */
    // K&R hash v2.
    private long HashFunction(String password) {
        long hash = 0;
        for (int i = 0; i < password.length(); i++) {
            hash = (long) (password.charAt(i) - '0') + 7 * hash;
        }
        return hash;
    }
}
