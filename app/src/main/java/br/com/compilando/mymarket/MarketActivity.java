package br.com.compilando.mymarket;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import adapter.ProductAdapter;
import data.MarketData;
import data.MyShoppingCart;
import model.Product;

public class MarketActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private RecyclerView recyclerViewProducts;
    private ProductAdapter productAdapter;
    private List<Product> products;
    private EditText searchText;
    private ImageView btnSearch;
    private Spinner spinnerProductCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);



        actionBar = getSupportActionBar();
        actionBar.setTitle("Mercadinho");

        recyclerViewProducts = findViewById(R.id.recycleViewProductsList);
        spinnerProductCategory = findViewById(R.id.spinnerProductsCategory);
        products = MarketData.getProductList();
        searchText = findViewById(R.id.editTextSearch);
        btnSearch = findViewById(R.id.imageViewSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage(searchText.getText().toString());

            }
        });




        /*********************OnTextSubmit*************************/
        /*
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //showMessage(searchText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                showMessage(searchText.getText().toString());
            }
        });
        */





        /**************** Configuração da RecycleView de produtos*************************/
        if (!products.isEmpty()){
            products.clear();
            products = MarketData.getProductList();
        }

        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        productAdapter = new ProductAdapter(products,getApplicationContext());
        recyclerViewProducts.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerViewProducts.setAdapter(productAdapter);
        /************************************************************************************/


        /**************************** Configuração do Spinner ***********************************/
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,R.array.products_category,android.R.layout.simple_dropdown_item_1line);
        spinnerProductCategory.setAdapter(arrayAdapter);
        AdapterView.OnItemSelectedListener escolha = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0){
                    String item = spinnerProductCategory.getSelectedItem().toString();
                    showMessage(item);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spinnerProductCategory.setOnItemSelectedListener(escolha);

        /***********************************************************************************************/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cart, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionMyCart:
                for (Product p : MyShoppingCart.getProductsInShoppingCart()){
                    System.out.println(p.getName());
                }
                return true;
            default:
                return true;
        }
    }

    private void showMessage(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
    public void teste(){
        android.app.AlertDialog.Builder mbuilder = new android.app.AlertDialog.Builder(MarketActivity.this);
        View v = getLayoutInflater().inflate(R.layout.dialog_add_to_cart,null);
        mbuilder.setView(v);
        AlertDialog alertDialog = mbuilder.create();
        alertDialog.show();
    }


}
