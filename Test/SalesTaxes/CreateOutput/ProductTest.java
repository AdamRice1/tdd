package SalesTaxes.CreateOutput;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class ProductTest {
    private Product product;
    private int amount;
    private String title;
    private double price;


    @Before
    public void create(){
        amount = 1;
        title = "Java Book";
        price = 1.50;
        product = new Product(amount, title, price);
    }
    @Test
    public void IsTheAmountRight() throws Exception {
        assertEquals(amount, product.getAmount(), 0);
    }
    @Test
    public void IsTheTitleRight() throws Exception {
        assertEquals(title, product.getTitle());
    }
    @Test
    public void ThePriceIsRight() throws Exception {
        assertEquals(price, product.getPrice(), 0);
    }
    @Test
    public void IsThisProductTaxExempt() throws Exception {
        String exemptTitle = "pills and books and chocolate";
        Product exemptProduct = new Product(amount, exemptTitle, price);
        assertTrue(exemptProduct.getTaxExempt());
        assertFalse(product.getTaxExempt());
    }
    @Test
    public void IsThisProductAnImport() throws Exception {
        String imported = "imported";
        Product importedProduct = new Product(amount, imported, price);
        assertFalse(product.getImport());
        assertTrue(importedProduct.getImport());
    }
}

