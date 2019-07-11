package adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.compilando.mymarket.MarketActivity;
import br.com.compilando.mymarket.R;
import data.MyShoppingCart;
import model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> products;
    private int quantity = 0;
    private Context context;
    LayoutInflater layoutInflater;
    public ProductAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override



    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_list_adapter,viewGroup,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder productViewHolder, final int i) {

        productViewHolder.nome.setText(products.get(i).getName());
        productViewHolder.price.setText("R$ "+ products.get(i).getPrice());
        productViewHolder.btnAddtoShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(products.get(i).getName());
                Toast.makeText(context,"Adicionado com sucesso",Toast.LENGTH_SHORT).show();
                MyShoppingCart.addToMyShoppingCart(products.get(i));

            }
        });

    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        private TextView nome;
        private TextView price;
        private ImageView btnAddtoShoppingCart;
        //TextView productQuantity;
        //ImageView btnProducdAdd;
        //ImageView getBtnProducdRemove;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textProductNameList);
            price = itemView.findViewById(R.id.textProductPriceList);
            btnAddtoShoppingCart = itemView.findViewById(R.id.imageViewAddToCart);
            //productQuantity = itemView.findViewById(R.id.textItemQuantity);
            //btnProducdAdd = itemView.findViewById(R.id.btnProducdAdd);
            //getBtnProducdRemove = itemView.findViewById(R.id.btnProducdRemove);
        }
    }
}
