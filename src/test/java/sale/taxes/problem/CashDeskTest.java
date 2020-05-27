package sale.taxes.problem;


import javafx.beans.binding.BooleanExpression;
import org.junit.Before;
import org.junit.Test;
import sale.taxes.problem.CashDesk;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class CashDeskTest {

    CashDesk desk;

    @Before
    public void setup(){

        desk = new CashDesk(){
            private List<Product> bucket = new ArrayList();
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

        };
    }


    @Test
    public void getSimpleReceiptTest(){
        desk.addProduct("2 book at 12.49");
        assertThat(desk.getReceipt()).isEqualTo("2 book: 24.98");
    }


}
