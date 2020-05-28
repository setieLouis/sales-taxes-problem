package sale.taxes.problem;

import lombok.Builder;
import lombok.Data;

@Data
public class Product {
    private final int quantity;
    private final String product;
    private final double price;
    private final double cost;
    private final double tax;

    @Builder
    Product(int quantity, String product , double price, int tax){
        this.quantity = quantity;
        this.product = product;
        this.price = price;
        int tmpTax = (int) (tax *  price * quantity);
        this.tax =  (double)  tmpTax / 100;
        this.cost = price * quantity + this.tax;

    }

    public String toString(){
        return getQuantity() + " " + getProduct() + ": " + this.getCost();
    }
}
