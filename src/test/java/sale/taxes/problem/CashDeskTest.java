package sale.taxes.problem;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;


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
        "3 imported box of chocolates: 31.5"+ '\n' +
        "Sales Taxes: 1.5" + '\n' +
        "Total: 57.33"
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


    @Test
    public void importedTaxTest() {
        desk.addProduct("1 imported bottle of perfume at 27.99");
        desk.addProduct("1 bottle of perfume at 18.99");
        desk.addProduct("1 packet of headache pills at 9.75");
        desk.addProduct("3 box of imported chocolates at 11.25");

        assertThat(desk.getReceipt()).isEqualTo(
                "1 imported bottle of perfume: 32.18\n" +
                "1 bottle of perfume: 20.88\n" +
                "1 packet of headache pills: 9.75\n" +
                "3 imported box of chocolates: 35.43\n" +
                "Sales Taxes: 7.76\n" +
                "Total: 98.24"
        );
    }
}
