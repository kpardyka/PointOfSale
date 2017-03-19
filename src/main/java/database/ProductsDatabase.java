package database;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsDatabase {
    List<Product> productList = new ArrayList<Product>() {
        {
            add(new Product("123", "Baton Pawełek", 2));
            add(new Product("124", "Merci", 12));
            add(new Product("125", "Herbata Lipton", 13));
            add(new Product("126", "Drożdżówka", 1));
            add(new Product("127", "Chleb", 3));
            add(new Product("128", "Czekolada Wedel", 3));
            add(new Product("129", "Czekolada Milka", 4));
            add(new Product("130", "Woda żywiec 0.5l", 1));
            add(new Product("131", "Coca - Cola 0.5l", 3));
            add(new Product("132", "Rafaello", 11));
        }
    };

    public Product find(String barCode) {
        for (Product p : productList) {
            if (p.getBarCode().equals(barCode)) {
                return p;
            }
        }
        return null;
    }


}
