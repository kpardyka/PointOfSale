package model;

import java.util.ArrayList;
import java.util.List;

public class Summary {
    private int totalSum = 0;
    private List<Product> boughtProducts = new ArrayList<>();


    public void add(Product product) {
        boughtProducts.add(product);
        totalSum += product.getPrice();
    }

    public int getTotalSum() {
        return totalSum;
    }

    public List<Product> getBoughtProducts() {
        return boughtProducts;
    }
}
