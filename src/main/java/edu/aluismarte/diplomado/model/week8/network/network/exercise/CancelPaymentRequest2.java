package edu.aluismarte.diplomado.model.week8.network.network.exercise;

import edu.aluismarte.diplomado.model.week8.network.PaymentProvider;
import lombok.*;

/**
 * @author aluis on 4/24/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CancelPaymentRequest2 {

    private String id;
    private PaymentProvider provider;
}
