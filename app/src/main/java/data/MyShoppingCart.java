package data;

import java.util.ArrayList;
import java.util.List;

import model.Product;

public class MyShoppingCart {
    private static List<Product> products = new ArrayList<>();
    public static void addToMyShoppingCart(Product product){
        products.add(product);
    }
    public static List<Product> getProductsInShoppingCart(){
        return products;
    }
}
