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
        assertThat(desk.getReceipt()).isEqualTo("2 book: 24.98");
    }


}
