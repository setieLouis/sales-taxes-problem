package sale.taxes.problem;


import org.junit.Before;
import sale.taxes.problem.CashDesk;

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
}
