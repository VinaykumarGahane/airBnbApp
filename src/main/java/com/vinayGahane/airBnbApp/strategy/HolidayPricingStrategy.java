package com.vinayGahane.airBnbApp.strategy;

import com.vinayGahane.airBnbApp.entity.Inventory;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class HolidayPricingStrategy implements PricingStrategy{

    private final PricingStrategy wrapper;

    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        BigDecimal price = wrapper.calculatePrice(inventory);
        boolean isHolidayToday = true;
        if(isHolidayToday){
            price = price.multiply(BigDecimal.valueOf(1.25));
        }
        return price;
    }
}
