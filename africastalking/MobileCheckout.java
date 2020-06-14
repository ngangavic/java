package africastalking;

import com.africastalking.AfricasTalking;
import com.africastalking.PaymentService;
import com.africastalking.payment.response.CheckoutResponse;

import java.util.HashMap;

public class MobileCheckout {

    public static void main(String[] args){
        /* Set your app credentials */
        String USERNAME = "sandbox";
        String API_KEY = "2ce68a356dd89ac1bed520d8dc4390dde575b03d0818e08702a7afe5f7785644";

        /* Initialize SDK */
        AfricasTalking.initialize(USERNAME, API_KEY);

        /* Get the payments service */
        PaymentService payment = AfricasTalking.getService(AfricasTalking.SERVICE_PAYMENT);

        /* Set the name of your Africa's Talking payment product */
        String productName = "house listing";

        /* Set the phone number you want to send to in international format */
        String phoneNumber = "+2547";

        /* Set The 3-Letter ISO currency code and the checkout amount */
        String currencyCode = "KES";
        float amount = 100;

		/*
			Set any metadata that you would like to send along with this request.
			This metadata will be included when we send back the final payment notification
		*/
        HashMap<String, String> metadata = new HashMap<String, String>();
        metadata.put("account", "-oc4m9um34xu2r89u8925u");

        /* That's it hit send and we'll take care of the rest */
        try {
            CheckoutResponse response = payment.mobileCheckout(
                    productName, phoneNumber, currencyCode, amount, metadata);
            System.out.println(response.toString());

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
