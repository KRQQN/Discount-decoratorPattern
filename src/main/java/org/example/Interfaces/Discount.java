package org.example.Interfaces;

import org.example.Product;

public interface Discount {
    double apply(Product product);
    String getDescription(Product product);
}
