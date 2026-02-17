package com.vinayGahane.airBnbApp.strategy;

import com.vinayGahane.airBnbApp.entity.Inventory;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal calculatePrice(Inventory inventory);

}
