package data;

import java.util.ArrayList;
import java.util.List;

import model.Market;
import model.Product;

public class MarketData {
    private static List<Product> products = new ArrayList<Product>();
    private static List<Market> markets = new ArrayList<>();


    public static List<Market> getMarketList(){
        Product p = new Product(1,"Leite",5.0F,"Comida");
        Product p1 = new Product(2,"Café",6.30F,"Comida");
        Product p2 = new Product(1,"Açucar",2.50F,"Comida");

        products.add(p);
        products.add(p1);
        products.add(p2);

        Market m = new Market();
        Market m1 = new Market();
        Market m2 = new Market();
        Market m3 = new Market();

        m.setCod(1);
        m.setDesc("Mercadorias em geral");
        m.setFunctionTime("22:00");
        m.setName("O Modesto");
        m.setUrlImage("asdasds");
        m.setProducts(products);
        m.setNeighborhood("Cangalheiro");


        m1.setCod(1);
        m1.setDesc("Mercadorias em geral");
        m1.setFunctionTime("22:00");
        m1.setName("Mercadinho do Seu Zé");
        m1.setUrlImage("asdasds");
        m1.setProducts(products);
        m1.setNeighborhood("Cangalheiro");

        m2.setCod(1);
        m2.setDesc("Mercadorias em geral");
        m2.setFunctionTime("22:00");
        m2.setName("Carvalho");
        m2.setUrlImage("asdasds");
        m2.setProducts(products);
        m2.setNeighborhood("Cangalheiro");

        m3.setCod(1);
        m3.setDesc("Mercadorias em geral");
        m3.setFunctionTime("22:00");
        m3.setName("Dona Benta");
        m3.setUrlImage("asdasds");
        m3.setProducts(products);
        m3.setNeighborhood("Cangalheiro");

        markets.add(m);
        markets.add(m1);
        markets.add(m2);
        markets.add(m3);
        return markets;

    }

    public static List<Product> getProductList(){
        Product p = new Product(1,"Leite",5.0F,"Comida");
        Product p1 = new Product(2,"Café",6.30F,"Comida");
        Product p2 = new Product(1,"Açucar",2.50F,"Comida");

        products.add(p);
        products.add(p1);
        products.add(p2);



        return products;

    }
}
