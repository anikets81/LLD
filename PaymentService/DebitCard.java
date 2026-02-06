package PaymentService;

public class DebitCard extends Card {
    public DebitCard(Integer cardNumber, String name) {
        super(cardNumber, name);
    }

    public void pay(){
        System.out.println("Payment Payment via debit card");
    }
}
