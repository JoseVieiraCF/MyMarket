package adapter;

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

import br.com.compilando.mymarket.R;
import model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    List<Product> products;
    int quantity = 0;
    public ProductAdapter(List<Product> products) {
        this.products = products;
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
        productViewHolder.price.setText("R$ "+ String.valueOf(products.get(i).getPrice()));



        productViewHolder.btnProducdAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                productViewHolder.productQuantity.setText(String.valueOf(products.get(i).getQuantity()));
                System.out.println(products.get(i).getName());
            }
        });

    }

    private String addmore() {
        quantity++;
        return String.valueOf(quantity);
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
        TextView nome;
        TextView price;
        TextView productQuantity;
        ImageView btnProducdAdd;
        ImageView getBtnProducdRemove;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textProductNameList);
            price = itemView.findViewById(R.id.textProductPriceList);
            btnProducdAdd = itemView.findViewById(R.id.btnProducdAdd);
            getBtnProducdRemove = itemView.findViewById(R.id.btnProducdRemove);
            productQuantity = itemView.findViewById(R.id.textItemQuantity);
        }
    }
}
