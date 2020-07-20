package SalesTaxes.CreateOutput;

import java.util.regex.Pattern;

public class Product {
    private int amount;
    private String title;
    private double price;
    private Boolean Import = false;
    private Boolean TaxExempt = false;
    private double totalAfterTax;

    public Product(int amount, String title, double price) {
        this.amount = amount;
        this.title = title;
        this.price = price;
        setCountryofOriginorProductType(title);
    }

    public long getAmount() {
        return amount;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public Boolean getImport() {
        return Import;
    }

    public Boolean getTaxExempt() {
        return TaxExempt;
    }

    public double setTotalAfterTax(double cost){
        return this.totalAfterTax = cost;
    }

    public double getTotalAfterTax() {
        return totalAfterTax;
    }
    public double roundTheTotal(double nums){
        return Math.round(nums * 100.0)/100.0;
    }
    private void setCountryofOriginorProductType(String title){
        Pattern taxExemptMatch = Pattern.compile("pills|book|chocolate");
        Pattern importMatch = Pattern.compile("imported");
        if (taxExemptMatch.matcher(title).find()){
            this.TaxExempt = true;
        }
        if (importMatch.matcher(title).find()){
            this.Import = true;
        }
    }
}
