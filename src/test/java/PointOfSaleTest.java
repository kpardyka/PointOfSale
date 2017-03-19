import app.BarCodesScanner;
import database.ProductsDatabase;
import model.Product;
import model.Summary;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import outputDevices.Printer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class PointOfSaleTest {

    @Test
    public void shouldReturnValidObject() {
        ProductsDatabase productsDatabase = Mockito.mock(ProductsDatabase.class);
        Mockito.when(productsDatabase.find("123")).thenReturn(new Product("123", "Baton Pawełek", 2));
        Product result = productsDatabase.find("123");
        assertNotNull("Product found", result);
        assertEquals(2, result.getPrice());
        assertEquals("Baton Pawełek", result.getName());
    }

    @Test
    public void shouldReturnNull() {
        ProductsDatabase productsDatabase = Mockito.mock(ProductsDatabase.class);
        Assert.assertNull(productsDatabase.find("123"));
    }

    @Test
    public void shouldReturnTotalSum() {
        Summary summary = Mockito.mock(Summary.class);
        summary.add(new Product("123", "Baton Pawełek", 2));
        summary.add(new Product("123", "Baton Pawełek", 2));
        Mockito.when(summary.getTotalSum()).thenReturn(4);
        int result = summary.getTotalSum();
        assertEquals("The total sum is good calculated", 4, result);
    }


    @Test
    public void shouldPrintProductOnLCDDisplay() {
        FakeLCDDisplay fakeLCDDisplay = new FakeLCDDisplay();
        ProductsDatabase productsDatabase = Mockito.mock(ProductsDatabase.class);
        Mockito.when(productsDatabase.find("123")).thenReturn(new Product("123", "Baton Pawełek", 2));
        Mockito.when(productsDatabase.find("124")).thenReturn(new Product("124", "Merci", 12));
        Mockito.when(productsDatabase.find("300")).thenReturn(new Product("300", "Tarka", 15));

        BarCodesScanner scanner = new BarCodesScanner(productsDatabase, fakeLCDDisplay);

        Summary summary = new Summary();

        scanner.scanProduct("123", summary);
        assertEquals("Baton Pawełek 2", fakeLCDDisplay.getLastLine());
        scanner.scanProduct("124", summary);
        scanner.scanProduct("300", summary);

        assertEquals("Tarka 15", fakeLCDDisplay.getLastLine());
        fakeLCDDisplay.showTotalSumLCD(summary);
        assertEquals(29, fakeLCDDisplay.getSum());

    }

    @Test
    public void shouldPrintReceipt() {
        Printer printer = new Printer();
        FakeLCDDisplay fakeLCDDisplay = new FakeLCDDisplay();
        ProductsDatabase productsDatabase = Mockito.mock(ProductsDatabase.class);
        Mockito.when(productsDatabase.find("123")).thenReturn(new Product("123", "Baton Pawełek", 2));
        Mockito.when(productsDatabase.find("124")).thenReturn(new Product("124", "Merci", 12));
        Mockito.when(productsDatabase.find("300")).thenReturn(new Product("300", "Tarka", 15));
        BarCodesScanner scanner = new BarCodesScanner(productsDatabase, fakeLCDDisplay);
        Summary summary = new Summary();
        scanner.scanProduct("123", summary);
        scanner.scanProduct("124", summary);
        scanner.scanProduct("300", summary);

        printer.printAllBoughtProducts(summary);

        assertEquals("Baton Pawełek 2\nMerci 12\nTarka 15\nTotal sum 29", printer.getReceipt());


    }


}
