package br.com.compilando.mymarket;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapter.MarketAdpter;
import data.MarketData;
import model.Market;
import model.Product;


public class MarketsFragment extends Fragment {

    private RecyclerView rvMarket;
    private List<Market> markets;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_markets, container, false);
        rvMarket = view.findViewById(R.id.market_list);
        markets = MarketData.getMarketList();
        if (!markets.isEmpty()){
            markets.clear();
            markets = MarketData.getMarketList();
        }
        MarketAdpter adapterItem = new MarketAdpter(markets,getContext());
        rvMarket.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMarket.setAdapter(adapterItem);


        return view;
    }

    public static MarketsFragment newInstance() {
        return new MarketsFragment();
    }

}
