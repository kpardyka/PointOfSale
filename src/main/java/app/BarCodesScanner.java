package app;

import database.ProductsDatabase;
import model.Product;
import model.Summary;
import outputDevices.Display;

import java.util.Scanner;

public class BarCodesScanner {

    private ProductsDatabase productsDatabase;
    private Display display;

    public BarCodesScanner(ProductsDatabase database, Display display) {
        this.productsDatabase = database;
        this.display = display;
    }

    public Summary scan() {
        Summary summary = new Summary();

        Scanner scanner = new Scanner(System.in);
        String barCode;

        do {
            System.out.println("Podaj bar code");
            barCode = scanner.nextLine();
            if (barCode.isEmpty()) {
                System.out.println("Invalid bar-code");
                continue;
            }
            scanProduct(barCode, summary);
        } while (!barCode.equalsIgnoreCase("exit"));

        return summary;
    }

    public void scanProduct(String barCode, Summary summary) {
        Product product = productsDatabase.find(barCode);
        if (product != null) {
            display.showProduct(product);
            System.out.println();
            summary.add(product);
        } else if (!barCode.equalsIgnoreCase("exit")) {
            System.out.println("Product not found");
        }
    }
}
