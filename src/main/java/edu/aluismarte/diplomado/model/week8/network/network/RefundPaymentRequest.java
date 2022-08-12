package edu.aluismarte.diplomado.model.week8.network.network;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author aluis on 4/24/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RefundPaymentRequest {

    private String id;
    private String provider;
    private BigDecimal amount;
}
