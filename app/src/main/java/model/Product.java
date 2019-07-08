package model;

public class Product {
    private int productCod;
    private String name;
    private float price;
    private String category;
    private int quantity;


    public Product(int productCod, String name, float price, String category) {
        this.productCod = productCod;
        this.name = name;
        this.price = price;
        this.category = category;
        quantity = 0;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        quantity++;
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product() {
    }

    public int getProductCod() {
        return productCod;
    }

    public void setProductCod(int productCod) {
        this.productCod = productCod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
