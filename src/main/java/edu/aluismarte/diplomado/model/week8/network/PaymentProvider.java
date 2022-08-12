package edu.aluismarte.diplomado.model.week8.network;

import edu.aluismarte.diplomado.model.week8.network.payment.PaymentGateway;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author aluis on 6/26/2022.
 */
@RequiredArgsConstructor
public enum PaymentProvider {
    STRIPE(new VisaService()),
    PAYPAL(new PaypalService()),
    MASTERCARD(new MastercardService()),
    VISA(new VisaService());

    @Getter
    private final PaymentGateway paymentGateway;

}
