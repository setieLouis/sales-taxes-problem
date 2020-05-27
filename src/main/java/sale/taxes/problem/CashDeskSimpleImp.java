package sale.taxes.problem;

import java.util.ArrayList;
import java.util.List;

public class CashDeskSimpleImp implements  CashDesk{

    private List<Product> bucket;

    CashDeskSimpleImp(){
        bucket = new ArrayList();
    }

    @Override
    public void addProduct(String element) {
        int atIndex = element.indexOf(" at");
        String quantity =  element.substring(0,2).trim();
        String product =  element.substring(2, atIndex );
        String price =  element.substring(atIndex + 3).trim();

        bucket.add(
                Product.builder()
                        .quantity(Integer.parseInt(quantity))
                        .product(product)
                        .price(Double.parseDouble(price))
                        .build()
        );
    }

    @Override
    public String getReceipt() {
        StringBuilder builder = new StringBuilder();
        double total = 0.0;
        for(Product prod : bucket){
            builder.append(prod.toString() +'\n');
            total += prod.getCost();
        }
        builder.append("Total: " + total);
        return builder.toString();
    }
}
