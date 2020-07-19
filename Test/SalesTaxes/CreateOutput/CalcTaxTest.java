package SalesTaxes.CreateOutput;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcTaxTest {
    private Checkout checkout;
    private Product prod1;
    private Product prod2;
    private CalcTax calcTax;

    @Before
    public void create(){
        checkout = new Checkout();
        prod1 = checkout.addProduct(1, "imported box of chocolates", 10.00);
        prod2 = checkout.addProduct(1, "imported bottle of perfume", 47.50);
        calcTax = new CalcTax((checkout.getStore()));
    }

    @Test
    public void AreWeGettingTheTaxRight() throws Exception {
        double expectedTax = 7.65;
        double taxTotal = calcTax.getTaxAmount();
        assertEquals(expectedTax, taxTotal, 0);
    }
    @Test
    public void AreWeGettingTheSaleRight() throws Exception {
        double expectedTotal = 65.15;
        double Total = Math.floor(calcTax.getSaleAmount() * 100) /100;
        assertEquals(expectedTotal, Total, 0);

    }
}
