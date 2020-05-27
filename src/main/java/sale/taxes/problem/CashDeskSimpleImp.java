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
        String quantity =  element.substring(0,2).trim();
        String product =  element.substring(2, element.indexOf("at") -1 );
        String price =  element.substring(element.indexOf("at") + 2).trim();

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
        bucket.forEach( prod -> builder.append(prod.toString()));
        return builder.toString();
    }
}
