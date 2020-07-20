package SalesTaxes.CreateOutput;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class CheckoutTest {
    private Checkout checkout;
    private Product product;

@Before
    public void create(){
    checkout = new Checkout();
    product = checkout.addProduct(1, "Java Book", 1.50);
}
@Test
    public void NewProductInTheStore() throws Exception {
    assertEquals(1, checkout.getStore().size());
}
@Test
    public void TheStoreList() throws Exception {
    assertEquals(ArrayList.class, checkout.getStore().getClass());
}

}
