package src.main.java.user;

public class Hash {

    // constructor
    public Hash() {
    };

    // Hash Function
    public long HashPassword(String password) {
        return HashFunction(password);
    }

    // K&R hash v2.
    private long HashFunction(String password) {
        long hash = 0;
        for (int i = 0; i < password.length(); i++) {
            hash = (long) (password.charAt(i) - '0') + 7 * hash;
        }
        return hash;
    }
}
