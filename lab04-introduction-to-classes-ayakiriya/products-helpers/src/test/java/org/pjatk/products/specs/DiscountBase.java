package org.pjatk.products.specs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pjatk.products.DiscountCalculator;
import org.pjatk.products.Product;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public abstract class DiscountBase {

    protected ArrayList<Product> products;

    protected DiscountCalculator calculator;

    protected Product p1 = new Product();

    protected Product p2 = new Product();

    protected Product p3 = new Product();

    protected Product p4 = new Product();

    @BeforeEach
    protected void setUp() {
        p1.price=300;
        p2.price=200;
        p3.price=100;
        p4.price=500;

        products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        calculator = new DiscountCalculator();

        calculator.products = products;
    }
}
