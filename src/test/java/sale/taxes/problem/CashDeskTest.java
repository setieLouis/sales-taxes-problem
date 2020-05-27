package sale.taxes.problem;


import javafx.beans.binding.BooleanExpression;
import org.junit.Before;
import org.junit.Test;
import sale.taxes.problem.CashDesk;

import static org.assertj.core.api.Assertions.*;


public class CashDeskTest {

    CashDesk desk;

    @Before
    public void setup(){
        desk = new CashDesk(){
            @Override
            public void addProduct(String product) {

            }

            @Override
            public String getReceipt() {
                return null;
            }
        };
    }


    @Test
    public void getSimpleReceiptTest(){
        desk.addProduct("2 book at 12.49");
        assertThat(desk.getReceipt()).isEqualTo("2 book: 24.98");
    }


}
