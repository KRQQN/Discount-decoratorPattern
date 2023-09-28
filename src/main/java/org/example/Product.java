package org.example;

public record Product(String name, double price, int qty) {
    public Double getSum() {
        return price * qty;
    }
}

