package SalesTaxes.CreateOutput;

import java.util.List;

public class CalcTax {
    private double taxAmount = 0.00;
    private double saleAmount = 0.00;
    private double productTotal = 0.00;

    public CalcTax(List<Product> products){
        for(Product product: products){
            this.productTotal = this.productTotal + (product.getPrice());
            this.taxAmount = roundTheTotal(taxAmount + SalesTax(product));
        }
        this.saleAmount = roundTheTotal(productTotal + this.taxAmount);
    }

    private double SalesTax(Product product){
        Double taxRate = .10;
        if(product.getTaxExempt()){
            taxRate = .00;
        }
        if(product.getImport()){
            taxRate = taxRate + .05;
        }
        if(product.getImport() != true && product.getTaxExempt() != true) {
           double roundTheTax1 = roundCost(product.getPrice()*taxRate);
           double newTotal = roundTheTotal(roundTheTax1 + product.getPrice());
           product.setTotalAfterTax(newTotal);
           return roundTheTax1;
        }
        double roundTheTax = roundCost((product.getPrice()*taxRate));
        product.setTotalAfterTax(roundTheTax + (product.getPrice()));
        return roundTheTax;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }
    public double roundTheTotal(double nums){
        return Math.round(nums * 100.0)/100.0;
    }
    public Double getSaleAmount() {
        return saleAmount;
    }

    private Double roundCost(Double num){
        return Math.ceil((num * 20.0)) / 20.0;
    }
    private Double CalcSalesTotal(){
        return this.saleAmount = (this.taxAmount + this.productTotal);
    }
}
