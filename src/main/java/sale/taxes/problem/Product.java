package sale.taxes.problem;

import lombok.Builder;
import lombok.Data;

@Data
public class Product {
    private final int quantity;
    private final String product;
    private final double price;

    @Builder
    Product(int quantity, String product , double price){
        this.quantity = quantity;
        this.product = product;
        this.price = price;
    }

    public String toString(){
        return getQuantity() + " " + getProduct() + ": " + price * quantity;
    }
}
