package edu.aluismarte.diplomado.model.week8.network.payment;

/**
 * @author aluis on 6/26/2022.
 */
public interface PaymentGateway extends PaymentProcess, CancelProcess, RefundProcess {

    String printWhoIAm();
}
