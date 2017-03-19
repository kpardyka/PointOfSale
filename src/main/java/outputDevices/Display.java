package outputDevices;

import model.Product;
import model.Summary;

public interface Display {

    public void showProduct(Product product);

    public void showTotalSumLCD(Summary summary);

}
