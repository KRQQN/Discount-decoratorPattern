package org.example.DiscountServices;

import org.example.Interfaces.Discount;
import org.example.Product;

public class QuantityDiscount extends BaseDiscount{
    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
        descripion = ", 5 or more products = -10kr/product";
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.qty() >=5;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.qty() * 10;
    }
}

