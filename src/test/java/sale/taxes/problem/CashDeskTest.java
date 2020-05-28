package sale.taxes.problem;


import javafx.beans.binding.BooleanExpression;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import sale.taxes.problem.CashDesk;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class CashDeskTest {


    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    CashDesk desk;

    @Before
    public void setup(){
        desk = new CashDeskSimpleImp();
    }

    @Test
    public void getSimpleReceiptTest(){
        desk.addProduct("2 book at 12.49");
        assertThat(desk.getReceipt()).isEqualTo(
                "2 book: 24.98" + '\n' +
                "Sales Taxes: 0.0" + '\n' +
                "Total: 24.98"
        );
    }

  @Test
    public void getSimpleReceiptMassiveTest() {
      desk.addProduct("2 book at 12.49");
      desk.addProduct("1 chocolate bar at 0.85");
      desk.addProduct("3 imported box of chocolates at 10.00");
      assertThat(desk.getReceipt()).isEqualTo(
        "2 book: 24.98" + '\n' +
        "1 chocolate bar: 0.85" + '\n' +
        "3 imported box of chocolates: 30.0"+ '\n' +
        "Sales Taxes: 0.0" + '\n' +
        "Total: 55.83"
      );
  }
    @Test
    public void basicTaxTest() {
        desk.addProduct("1 music CD at 14.99");
        assertThat(desk.getReceipt()).isEqualTo(
            "1 music CD: 16.48" + '\n' +
            "Sales Taxes: 1.49" + '\n' +
            "Total: 16.48"
        );
    }

}
