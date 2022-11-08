package src.main.java.payment;

/**
 * A Payment Interface.
 * @author Boon Hian Lim
 * @version 1.0
 * @since 2022-11-01
 */
public interface PaymentMethodInterface {
    /**
     * Abstract payment function.
     * @param fare Price of the ticket.
     * @return Integer representation of payment status.
     */
    public int pay(double fare);
    /**
     * Validation function to check payment is successful.
     * @return Integer representation of payment status.
     */
    public int validation();
}
