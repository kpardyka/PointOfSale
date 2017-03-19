package model;

public class Product {
    private String barCode;
    private String name;
    private int price;

    public Product(String barCode, String name, int price) {
        this.barCode = barCode;
        this.name = name;
        this.price = price;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }
}
