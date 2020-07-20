package SalesTaxes.CreateOutput;

public class TaxPrint {

    public void purchased(Product product){
        System.out.println(product.getAmount() + " " + product.getTitle() + ".............. Total: " + product.getTotalAfterTax());
    }

    public void taxAmount(double tax){
        System.out.println("Sales Tax.................... " + tax);
    }

    public void totalPurchase(double total){
        System.out.println("Total...................." + total);
    }

    public void space(){
        for(int i = 0; i < 5; i++){
            System.out.println("\n");
        }
    }
}
