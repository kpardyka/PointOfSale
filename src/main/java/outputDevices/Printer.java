package outputDevices;

import model.Product;
import model.Summary;

import java.util.List;

public class Printer {
    private String receipt;

    public void printAllBoughtProducts(Summary summary) {
        System.out.println("Receipt: ");
        List<Product> boughtProducts = summary.getBoughtProducts();
        StringBuilder stringBuilder = new StringBuilder();
        for (Product p : boughtProducts) {
            String line = p.getName() + " " + p.getPrice();
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        stringBuilder.append("Total sum ");
        stringBuilder.append(summary.getTotalSum());
        receipt = stringBuilder.toString();
        System.out.println(receipt);

    }

    public String getReceipt() {
        return receipt;
    }
}



