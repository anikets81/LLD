package PaymentService;

public class client {
    public static void main(String[] args) {
        paymentService ps = new paymentService();
        ps.addPaymentMethod("AniketCreditCard",  new CreditCard(2341, "Aniket Credit Card"));
        ps.addPaymentMethod("AniketDebitCard",  new DebitCard(1234, "Aniket Debit Card"));
        ps.addPaymentMethod("AniketUPI",  new UPI("12345"));

        ps.makePayment("AniketCreditCard");
        ps.makePayment("AniketDebitCard");
        ps.makePayment("AniketUPI");
    }
}
