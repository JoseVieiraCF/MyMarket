package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.compilando.mymarket.MarketActivity;
import br.com.compilando.mymarket.R;
import model.Market;

public class MarketAdpter  extends RecyclerView.Adapter<MarketAdpter.MyViewHolder> {
    List<Market> markets;
    private Context context;

    public MarketAdpter(List<Market> markets, Context context) {
        this.markets = markets;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =   LayoutInflater.from(context).inflate(R.layout.market_list_adapter_teste, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.name.setText(markets.get(i).getName());
        myViewHolder.desc.setText(markets.get(i).getDesc());
        myViewHolder.neighborhood.setText(markets.get(i).getNeighborhood());
        myViewHolder.functionTime.setText(markets.get(i).getFunctionTime());


        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "posicao "+myViewHolder.getAdapterPosition(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MarketActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return markets.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView desc;
        private TextView functionTime;
        private TextView neighborhood;

        public MyViewHolder( View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.MarketTextNameList);
            desc = itemView.findViewById(R.id.MarketTextDescList);
            neighborhood = itemView.findViewById(R.id.MarketTextNeighborhoodList);
            functionTime = itemView.findViewById(R.id.MarketTextFunctionTimeList);

        }
    }
}



