import model.Product;
import model.Summary;
import outputDevices.Display;

public class FakeLCDDisplay implements Display {

    private String lastLine;
    private int sum;

    public void showProduct(Product product) {
        lastLine = product.getName() + " " + product.getPrice();
    }

    public void showTotalSumLCD(Summary summary) {
        sum = summary.getTotalSum();
    }

    public String getLastLine() {
        return lastLine;
    }

    public int getSum() {
        return sum;
    }
}

