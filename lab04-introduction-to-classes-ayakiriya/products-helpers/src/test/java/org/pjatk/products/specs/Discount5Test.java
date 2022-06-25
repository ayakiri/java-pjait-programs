package org.pjatk.products.specs;

import org.junit.jupiter.api.Test;
import org.pjatk.products.Product;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Discount5Test extends DiscountBase {

    @Test
    public void test_should_Properly_Count_when_price_is_too_low_DiscountRate(){
        setUp();
        calculator.discountByPercentage(10000.0, 10);

        assertThat(p1.price, is(300.0));
        assertThat(p2.price, is(200.0));
        assertThat(p3.price, is(100.0));
        assertThat(p4.price, is(500.0));
    }

    @Test
    public void test_should_Properly_Count_DiscountRateTest(){
        setUp();
        calculator.discountByPercentage(1000.0, 10);

        assertThat(p1.price, is(270.0));
        assertThat(p2.price, is(180.0));
        assertThat(p3.price, is(90.0));
        assertThat(p4.price, is(450.0));
    }
}
