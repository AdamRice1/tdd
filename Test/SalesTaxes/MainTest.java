package SalesTaxes;

import SalesTaxes.CreateOutput.CalcTax;
import SalesTaxes.CreateOutput.Checkout;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
public class MainTest {
    private Checkout checkout;
    private CalcTax calcTax;
    private double expectedTaxTotal;
    private double expectedTotal;
    private double taxTotal;
    private double Total;


    @Before
    public void create(){
        checkout = new Checkout();
    }

    @Test
    public void input1()throws Exception {
        checkout.addProduct(1, "book", 12.49);
        checkout.addProduct(1, "music CD", 14.99);
        checkout.addProduct(1, "chocolate bar", 0.85);
        calcTax = new CalcTax(checkout.getStore());
        expectedTaxTotal = 1.50;
        expectedTotal = 29.83;
        taxTotal = (double) Math.round(calcTax.getTaxAmount() * 100)/100;
        Total = (double) Math.round(calcTax.getSaleAmount() * 100)/100;
        assertEquals(expectedTaxTotal, taxTotal, 0);
        assertEquals(expectedTotal, Total, 0);
    }
    @Test
    public void input2()throws Exception {
        checkout.addProduct(1, "imported box of chocolates", 10.00);
        checkout.addProduct(1, "imported bottle of perfumed", 47.50);
        calcTax = new CalcTax(checkout.getStore());
        expectedTaxTotal = 7.65;
        expectedTotal = 65.15;
        taxTotal = (double) Math.round(calcTax.getTaxAmount() * 100)/100;
        Total = (double) Math.round(calcTax.getSaleAmount() * 100)/100;
        assertEquals(expectedTaxTotal, taxTotal, 0);
        assertEquals(expectedTotal, Total, 0);
    }
    @Test
    public void input3()throws Exception {
        checkout.addProduct(1, "imported bottle of perfume", 27.99);
        checkout.addProduct(1, "bottle of perfume", 18.99);
        checkout.addProduct(1, "packet of headache pills", 9.75);
        checkout.addProduct(1, "box of imported chocolates", 11.25);
        calcTax = new CalcTax(checkout.getStore());
        expectedTaxTotal = 6.70;
        expectedTotal = 74.68;
        taxTotal = (double) Math.round(calcTax.getTaxAmount() * 100)/100;
        Total = (double) Math.round(calcTax.getSaleAmount() * 100)/100;
        assertEquals(expectedTaxTotal, taxTotal, 0);
        assertEquals(expectedTotal, Total, 0);
    }
}
