package PaymentService;

public class CreditCard extends Card {
    public CreditCard(Integer cardNumber, String name) {
        super(cardNumber, name);
    }

    public void pay(){
        System.out.println("Making Payment via Credit Card");
    }
}