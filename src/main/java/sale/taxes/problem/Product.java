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
    Product(int quantity, String product , double price, double tax){
        this.quantity = quantity;
        this.product = product;
        this.price = price;
        this.tax = (tax/100) *  price * quantity;
        this.cost = price * quantity + this.tax;

    }

    public String toString(){
        return getQuantity() + " " + getProduct() + ": " + this.getCost();
    }
}
