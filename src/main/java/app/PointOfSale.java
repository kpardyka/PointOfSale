package app;

import database.ProductsDatabase;
import model.Summary;
import outputDevices.LCDDisplay;
import outputDevices.Printer;

public class PointOfSale {
    public static void main(String[] args) {
        LCDDisplay lcdDisplay = new LCDDisplay();
        Printer printer = new Printer();
        ProductsDatabase database = new ProductsDatabase();
        BarCodesScanner barCodesScanner = new BarCodesScanner(database, lcdDisplay);

        Summary summary = barCodesScanner.scan();

        System.out.println();
        lcdDisplay.showTotalSumLCD(summary);
        printer.printAllBoughtProducts(summary);

    }
}
