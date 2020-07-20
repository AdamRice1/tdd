package SalesTaxes.CreateOutput;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    private List<Product> store = new ArrayList<Product>();

    public Product addProduct(int amount, String name, double price){
        Product product = new Product(amount, name, price);
        this.store.add(product);
        return product;
    }
    public List<Product> getStore(){
        return this.store;
    }
}
