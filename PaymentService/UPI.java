package PaymentService;

public class UPI implements paymentMethod{
    private String upiId;

    UPI(String upiId) {
        this.upiId = upiId;
    }

    public void pay(){
        System.out.println("Payment Via UPI: " + upiId);
    }


}
