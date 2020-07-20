package SalesTaxes;

import SalesTaxes.CreateOutput.*;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] items) throws IOException {
        String[] inputItems = {
                "assets/inputs/input0.txt",
                "assets/inputs/input1.txt",
                "assets/inputs/input2.txt"
        };
        String[] inputsToGoThrough = (items.length > 0) ?
                items : inputItems;

        System.out.println(inputItems);
        for(String shoppingCart : inputsToGoThrough){
            if (new File(shoppingCart).exists()){
                Cart cart = new Cart(shoppingCart);
                Checkout checkout = cart.getCheckout();
                CalcTax calc = new CalcTax(checkout.getStore());
                TaxPrint terminal = new TaxPrint();
                for(Product product: checkout.getStore()){
                    terminal.purchased(product);
                }

                terminal.taxAmount(calc.getTaxAmount());
                terminal.totalPurchase(calc.getSaleAmount());
                terminal.space();
            }
        }
    }
}
