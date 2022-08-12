package edu.aluismarte.diplomado.model.week8.network.payment;

import java.math.BigDecimal;

/**
 * Ejemplo de interfaz de responsabilidad única
 *
 * @author aluis on 4/24/2022.
 */
public interface RefundProcess {

    String refund(String id, BigDecimal amount);
}
