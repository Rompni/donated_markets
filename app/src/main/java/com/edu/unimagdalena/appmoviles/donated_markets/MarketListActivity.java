package com.edu.unimagdalena.appmoviles.donated_markets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MarketListActivity extends AppCompatActivity {

    ListView mklist;
    MarketController mc;
    ArrayList<Market> arrayOfMarkets;
    Market m;
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_list);

        mc = new MarketController(this);
        //EXAMPLE

        m = new Market(100, "Santa Cruz", "Calle 47B",
                "1081126732", "Julio Mario");
        if (mc.getMarket(m.getMarketID()) == null)
            mc.addMarket(m);

        // Construct the data source
        arrayOfMarkets= new ArrayList<>(mc.getAllMarkets());
        c = this;
        // Create the adapter to convert the array to views
        MarketAdapter adapter = new MarketAdapter(this, arrayOfMarkets);
        // Attach the adapter to a ListView
        mklist = (ListView) findViewById(R.id.marketList);
        mklist.setAdapter(adapter);
    }

}
