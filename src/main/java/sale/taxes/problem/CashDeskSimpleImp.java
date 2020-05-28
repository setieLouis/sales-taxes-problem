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
        String product =  element.substring(2, atIndex );
        String price =  element.substring(atIndex + 3).trim();
        double basicTax = getBasicTax(product);

        bucket.add(
                Product.builder()
                        .quantity(Integer.parseInt(quantity))
                        .product(product)
                        .price(Double.parseDouble(price))
                        .tax(basicTax)
                        .build()
        );
    }

    private double getBasicTax(String product) {
        double tax = 10.0;
        for(String s : this.freeBasicTaxGoods){
            if (product.contains(s)){
                tax = 0.0;
                break;
            }
        }

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
        builder.append("Sales Taxes: " + tax +'\n');
        builder.append("Total: " + total);
        return builder.toString();
    }
}
