package PaymentService;

import java.util.HashMap;

public class paymentService {
    HashMap<String, paymentMethod>paymentMethods;

    paymentService(){
        paymentMethods = new HashMap<>();
    }

    public void addPaymentMethod(String name, paymentMethod method){
        paymentMethods.put(name, method);
    }

    public void makePayment(String name){
        paymentMethod method = paymentMethods.get(name);
        method.pay();
    }
}
