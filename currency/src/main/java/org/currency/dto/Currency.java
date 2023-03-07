package org.currency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Currency {
    private String baseCurrency;
    private String compareCurrency;
    private double purchase;
    private double sale;

    @Override
    public String toString(){
        return String.format("Base currency: %s\nCompare currency: %s\nPurchase: %.2f\nSale: %.2f",
                baseCurrency, compareCurrency, purchase, sale);
    }
}
