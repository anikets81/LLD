package PaymentService;

abstract public class Card implements paymentMethod {
    private Integer cardNumber;
    private String name;

    Card(Integer cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }
    public String getName() {
        return name;
    }

    abstract public void pay();
}
