package model;

public class Product {
    private String nameProduct;
    private Float price;
    private Integer quantity;
    private Float totalValue;


    public Product(String nameProduct, Float price, Integer quantity) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
    }

    public String getNameProduct(){
        return nameProduct;
    }

    public void setNamePrioduct(String nameProduct){
        this.nameProduct = nameProduct;
    }
    
    public Float  getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTotalValue() {
        totalValue = quantity * price;
        return totalValue;
    }

    @Override
    public String toString(){
        return "Product name: " + getNameProduct() +
        " | " + "Product price: " + String.format("%.2f",getPrice()) +
        " | " + "Product quantity: "+ getQuantity() + 
        " | " + "total quantity of the money: " + String.format("%.2f", getTotalValue()) ;   
    }
}