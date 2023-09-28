package org.example;

import org.example.DiscountServices.*;
import org.example.Interfaces.Discount;

public class App {
    public static void main(String[] args) {

        Product product1 = new Product("Milk", 100,5);
        Product product2 = new Product("Gröt", 100,1);

        // Required discounts chained
        Discount discounts =
                new FridayDiscount(
                        new MilkDiscount(
                                new QuantityDiscount(new NoDiscount())));

        // General discount
        Discount customDiscount = new CustomDiscount(
                "-5% på gröt",
                product -> product.name().equalsIgnoreCase("gRöT"),
                product -> product.price() * 0.05,
                new NoDiscount()
        );

        // Discounts applied on the products
        var discountApplied = discounts.apply(product1);
        var customDiscountApplied = customDiscount.apply(product2);

        // Required discounts applied and description printed
        System.out.println("-"+ discountApplied +"Kr Rabatt.");
        System.out.println(discounts.getDescription(product1));

        // General discount discountammount printed
        System.out.println("-" + customDiscountApplied +"Kr Rabatt.");



    }
}
