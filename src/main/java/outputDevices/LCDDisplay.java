package outputDevices;

import model.Product;
import model.Summary;

public class LCDDisplay implements Display {

    public void showProduct(Product product) {
        System.out.println(product.getName() + " " + product.getPrice());
    }

    public void showTotalSumLCD(Summary summary) {
        System.out.println("[LCD] Total sum: ");
        System.out.println(summary.getTotalSum());
    }
}
