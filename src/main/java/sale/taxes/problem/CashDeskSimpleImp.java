package sale.taxes.problem;

import java.util.ArrayList;
import java.util.List;

public class CashDeskSimpleImp implements  CashDesk{

    private List<Product> bucket;
    private List<String> freeBasicTaxGoods;


    CashDeskSimpleImp(){
        bucket = new ArrayList();
        freeBasicTaxGoods = new ArrayList();
        freeBasicTaxGoods.add("book");
        freeBasicTaxGoods.add("chocolate");
        freeBasicTaxGoods.add("headache");
    }

    @Override
    public void addProduct(String element) {
        int atIndex = element.indexOf(" at");
        String quantity =  element.substring(0,2).trim();
        String product =  getProduct(element.substring(2, atIndex ));

        String price =  element.substring(atIndex + 3).trim();
        int tax = getTax(product);

        bucket.add(
                Product.builder()
                        .quantity(Integer.parseInt(quantity))
                        .product(product)
                        .price(Double.parseDouble(price))
                        .tax(tax)
                        .build()
        );
    }

    private String getProduct(String product) {
        if(product.contains("imported "))
            return "imported " +  product.replace("imported ", "");
        return product;
    }

    private int getTax(String product) {
        int tax = 10;
        // basic tax
        for(String s : this.freeBasicTaxGoods){
            if (product.contains(s)){
                tax = 0;
                break;
            }
        }

        if (product.contains("imported"))
            tax += 5;
        return tax;
    }

    @Override
    public String getReceipt() {
        StringBuilder builder = new StringBuilder();
        double total = 0.0;
        double tax = 0.0;
        for(Product prod : bucket){
            builder.append(prod.toString() +'\n');
            total += prod.getCost();
            tax += prod.getTax();
        }

        total =  (double)((int)(total * 100))/100;
        builder.append("Sales Taxes: " + tax +'\n');
        builder.append("Total: " + total);
        return builder.toString();
    }
}
