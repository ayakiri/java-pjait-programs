package org.pjatk.products.specs;


import org.junit.jupiter.api.Test;
import org.pjatk.products.Product;
import org.pjatk.products.ProductsSorter;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SortProductsTest extends DiscountBase{

    @Test
    public void should_properly_sort_collection_by_price_test(){
        setUp();
        ArrayList<Product> sortedProducts = ProductsSorter.sort(products);
        assertThat(sortedProducts, contains(p3, p2, p1, p4));
    }

    @Test
    public void test_should_get_the_most_expensive_product(){
        setUp();
        assertThat(ProductsSorter.mostExpensive(products), is(p4));
    }

    @Test
    public void test_should_get_the_cheapest_product_test(){
        setUp();
        assertThat(ProductsSorter.theCheapest(products), is(p3));
    }

    @Test
    public void test_should_get_n_cheapest_products_test(){
        assertThat(ProductsSorter.theCheapest(products, 2), containsInAnyOrder(p2, p3));
    }
}
