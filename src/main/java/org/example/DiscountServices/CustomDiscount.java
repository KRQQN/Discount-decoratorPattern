package org.example.DiscountServices;

import org.example.Interfaces.CalculateDiscount;
import org.example.Interfaces.Discount;
import org.example.Interfaces.IsApplicable;
import org.example.Product;

public class CustomDiscount extends BaseDiscount {
    private final IsApplicable isApplicable;
    private final CalculateDiscount calculateDiscount;

    public CustomDiscount(String _description,
                          IsApplicable _isApplicable,
                          CalculateDiscount _calculateDiscount,
                          Discount _nextDiscount
    ) {
        super(_nextDiscount);
        this.isApplicable = _isApplicable;
        this.calculateDiscount = _calculateDiscount;
        descripion = _description;
    }

    @Override
    protected boolean isApplicable(Product product) {
        return isApplicable.isApplicable(product);
    }

    @Override
    protected double calculateDiscount(Product product) {
        return calculateDiscount.calculateDiscount(product);
    }
}
