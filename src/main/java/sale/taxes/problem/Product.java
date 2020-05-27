package sale.taxes.problem;

import lombok.Builder;
import lombok.Data;

@Data
public class Product {
    private final int quantity;
    private final String product;
    private final double price;
    private final double cost;

    @Builder
    Product(int quantity, String product , double price){
        this.quantity = quantity;
        this.product = product;
        this.price = price;
        this.cost = price * quantity;
    }

    public String toString(){
        return getQuantity() + " " + getProduct() + ": " + this.getCost();
    }
}
