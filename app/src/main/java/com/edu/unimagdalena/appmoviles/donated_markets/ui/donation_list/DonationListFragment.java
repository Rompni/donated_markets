package com.edu.unimagdalena.appmoviles.donated_markets.ui.donation_list;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
import java.util.Locale;

public class DonationListFragment extends Fragment {

    ListView mklist;
    MarketController mc;
    ArrayList<Market> arrayOfMarkets;
    EditText search;
    Market m;
    Context c;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_donation_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        c = view.getContext();
        mc = new MarketController(c);
        long time = System.currentTimeMillis();

        m = new Market(500, "Santa Cruz", "Calle 47B",
                time, "Julio Mario");

        if (mc.getMarket(m.getMarketID()) == null)
            mc.addMarket(m);

        arrayOfMarkets= new ArrayList<>(mc.getAllMarkets());
        final MarketAdapter adapter = new MarketAdapter(c, arrayOfMarkets);
        mklist = view.findViewById(R.id.marketList);
        mklist.setAdapter(adapter);

        search = view.findViewById(R.id.neighborhood_find);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = search.getText().toString();
                adapter.filter(text);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}