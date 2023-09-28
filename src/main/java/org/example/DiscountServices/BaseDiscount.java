package org.example.DiscountServices;

import org.example.Interfaces.Discount;
import org.example.Product;

public abstract class BaseDiscount implements Discount {

    protected final Discount nextDiscount;
    protected String descripion;


    public BaseDiscount() {
        this.nextDiscount = new NoDiscount();
    }

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    @Override
    public double apply(Product product) {
        return isApplicable(product)
                ? calculateDiscount(product) + nextDiscount.apply(product)
                : nextDiscount.apply(product);
    }

    @Override
    public String getDescription(Product product) {
        return isApplicable(product)
                ? this.descripion + nextDiscount.getDescription(product)
                : nextDiscount.getDescription(product);
    }

    protected abstract boolean isApplicable(Product product);

    protected abstract double calculateDiscount(Product product);
}
