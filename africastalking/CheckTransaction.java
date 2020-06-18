package africastalking;

import com.africastalking.AfricasTalking;
import com.africastalking.PaymentService;
import com.africastalking.payment.Transaction;
import com.africastalking.payment.response.CheckoutResponse;

public class CheckTransaction {

    public static void main(String[] args) {
        /* Set your app credentials */
        String USERNAME = Secrets.username;
        String API_KEY = Secrets.apiKey;

        /* Initialize SDK */
        AfricasTalking.initialize(USERNAME, API_KEY);

        /* Get the payments service */
        PaymentService payment = AfricasTalking.getService(AfricasTalking.SERVICE_PAYMENT);

        try {
            Transaction response = payment.findTransaction("ATPid_e4eb8a8f3d93bd726330f4256c27fb4e");
            System.out.println(response.toString());

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
