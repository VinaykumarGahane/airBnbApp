package com.vinayGahane.airBnbApp.strategy;

import com.vinayGahane.airBnbApp.entity.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class SurgePricingStrategy implements PricingStrategy{

    private  final  PricingStrategy wrapper;
    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        BigDecimal price = wrapper.calculatePrice(inventory);
        return price.multiply(inventory.getSurgeFactor());
    }
}
