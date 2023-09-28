package org.example.DiscountServices;


import org.example.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomDiscountTest {
    Product oatmeal = new Product("GröT", 100, 1);
    Product milk = new Product("MiLK", 100, 1);
    Product hotdog = new Product("KÖRV", 100, 1);

    CustomDiscount hotdogDiscount = new CustomDiscount(
            "100% discount on körv, cause körv should be free!",
            product -> product.name().equalsIgnoreCase("körv"),
            product -> product.price() * 1,
            new NoDiscount()
    );

    CustomDiscount oatmealDiscount = new CustomDiscount(
            "-5% oatmeal discount",
            product -> product.name().equalsIgnoreCase("körv"),
            product -> product.price() * 0.05,
            new NoDiscount()
    );

    @Test
    void isApplicable() {
        assertEquals(100.0, hotdogDiscount.apply(hotdog));
        assertTrue(hotdogDiscount.isApplicable(hotdog));
        assertFalse(hotdogDiscount.isApplicable(milk));
    }

    @Test
    void calculateDiscount() {
        assertEquals(5.0, oatmealDiscount.calculateDiscount(oatmeal));
    }
}