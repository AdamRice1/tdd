package SalesTaxes.CreateOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cart {
    private Checkout checkout;

    public Cart(String cart) {
        try {
            BufferedReader inputs = new BufferedReader(new FileReader(cart));
            String inputList;
            this.checkout = new Checkout();
            while ((inputList = inputs.readLine()) != null) {
                this.checkout.addProduct(
                        readAmount(inputList),
                        readTitle(inputList),
                        readPrice(inputList)
                );
            }
            inputs.close();
        } catch (Exception e) {
            System.err.println("An error occured in the reading." + e.getMessage());
        }
    }


    public Checkout getCheckout() {
        return this.checkout;
    }
    private int readAmount(String sent){
        Pattern r = Pattern.compile("^[\\d+]");
        Matcher x = r.matcher(sent);
        x.find();
        return Integer.parseInt(x.group(0));
    }
    private String readTitle(String sent){
        Pattern r = Pattern.compile("(?!^\\d)[A-Za-z].+(?=\\sat\\s\\d+.\\d+$)");
        Matcher x = r.matcher(sent);
        x.find();
        return x.group(0);
    }
    private double readPrice(String sent){
        Pattern r = Pattern.compile("\\d+.\\d+$");
        Matcher x = r.matcher(sent);
        x.find();
        return Double.parseDouble(x.group(0));
    }
}