package org.example.DiscountServices;

import org.example.Interfaces.Discount;
import org.example.Product;

public class MilkDiscount extends BaseDiscount  {
    public MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
        descripion = ", -5% ON MILK";
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.name().equalsIgnoreCase("milk");
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.getSum() * 0.05;
    }


}



