package com.elliott.JavaLeetCodeSolutions.controllers;

import com.elliott.JavaLeetCodeSolutions.models.User;
import com.elliott.JavaLeetCodeSolutions.repositories.UserRepository;
import com.elliott.JavaLeetCodeSolutions.services.UserService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Subscription;
import com.stripe.model.checkout.Session;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.PriceListParams;
import com.stripe.param.SubscriptionCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/checkout")
public class StripeController {

    @Autowired
    private UserService userService;

    private String stripeKey = Stripe.apiKey = "sk_test_51E89VVIUupCxt3YboFWGG6gZ7PX7xZNJ9K82x9HOIXNUM1II4OCg1813299W2rYmhGNm00OmdBNfQnXEHRJRuC4900zDiuLMYJ";

    @GetMapping("subscribe")
    public String subscribe(){

        return "subscribe";
    }
    @GetMapping("/success")
    public String success(){
        return "subscriptionSuccess";
    }
    @GetMapping("/cancel")
    public String cancel(){
        return "cancel";
    }
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "register";
    }
    @PostMapping("/register")
    public String registerPost(User user) throws StripeException {

       this.userService.saveUser(user);

        return "register";
    }


    @PostMapping("/create-checkout-session")
    public String another(String priceId,String email,String name) throws StripeException {

        System.out.println(priceId);
        System.out.println(email);
        System.out.println(name);

//    Customer stripeCustomer = createCustomer();
//        // Automatically save the payment method to the subscription
//        // when the first payment is successful.
//        SubscriptionCreateParams.PaymentSettings paymentSettings =
//                SubscriptionCreateParams.PaymentSettings
//                        .builder()
//                        .setSaveDefaultPaymentMethod(SubscriptionCreateParams.PaymentSettings.SaveDefaultPaymentMethod.ON_SUBSCRIPTION)
//                        .build();
//
//        SubscriptionCreateParams subCreateParams = SubscriptionCreateParams
//                .builder()
//                .setCustomer(stripeCustomer.getId())
//                .addItem(
//                        SubscriptionCreateParams
//                                .Item.builder()
//                                .setPrice(priceId)
//                                .build()
//                )
//                .setPaymentSettings(paymentSettings)
//                .setPaymentBehavior(SubscriptionCreateParams.PaymentBehavior.DEFAULT_INCOMPLETE)
//                .addAllExpand(Arrays.asList("latest_invoice.payment_intent"))
//                .build();
//        Subscription subscription = Subscription.create(subCreateParams);
//        String subId = subscription.getId();
//        String clientSecret = subscription.getLatestInvoiceObject().getPaymentIntentObject().getClientSecret();



        return "checkout";
    }

}
