package com.edu.unimagdalena.appmoviles.donated_markets.ui.donation_list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.edu.unimagdalena.appmoviles.donated_markets.Market;
import com.edu.unimagdalena.appmoviles.donated_markets.MarketAdapter;
import com.edu.unimagdalena.appmoviles.donated_markets.MarketController;
import com.edu.unimagdalena.appmoviles.donated_markets.R;

import java.util.ArrayList;

public class DonationListFragment extends Fragment {

    ListView mklist;
    MarketController mc;
    ArrayList<Market> arrayOfMarkets;
    Market m;
    Context c;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_donation_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //final TextView textView = view.findViewById(R.id.text_gallery);
        //textView.setText("Lista de Donaciones");
        c = view.getContext();

        mc = new MarketController(c);
        m = new Market(100, "Santa Cruz", "Calle 47B",
                "1081126732", "Julio Mario");
        if (mc.getMarket(m.getMarketID()) == null)
            mc.addMarket(m);

        arrayOfMarkets= new ArrayList<>(mc.getAllMarkets());
        MarketAdapter adapter = new MarketAdapter(c, arrayOfMarkets);
        mklist = (ListView) view.findViewById(R.id.marketList);
        mklist.setAdapter(adapter);
    }
}