package SalesTaxes.CreateOutput;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CartTest {
    private Cart cart;
    private Checkout checkout;
    private Checkout readCheckout;
    private Product product1;
    private Product product2;
    private Product product3;

    @Before
    public void create(){
        cart = new Cart("assets/inputs/input0");
        readCheckout = cart.getCheckout();
        checkout = new Checkout();
        product1 = checkout.addProduct(1, "book", 12.49);
        product2 = checkout.addProduct(1, "music  cd", 14.99);
        product3 = checkout.addProduct(1, "chocolate bar", 0.85);
    }

    @Test
    public void createReadProduct() throws Exception {
        assertEquals(Checkout.class , readCheckout.getClass());
    }

}
