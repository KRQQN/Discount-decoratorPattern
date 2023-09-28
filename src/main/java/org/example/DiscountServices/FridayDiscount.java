package org.example.DiscountServices;

import org.example.Interfaces.Discount;
import org.example.Product;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class FridayDiscount extends BaseDiscount {
    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
        descripion = ", -10% Fridaydiscount";
    }

    @Override
    protected boolean isApplicable(Product product) {
        return LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.getSum() * 0.1;
    }
}

