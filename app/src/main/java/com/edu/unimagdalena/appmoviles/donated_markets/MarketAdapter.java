package com.edu.unimagdalena.appmoviles.donated_markets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MarketAdapter extends ArrayAdapter<Market> {

    private TextView neighborhood, homeaddress, person, code, date;
    private ArrayList<Market> markets, copyMarkets;
    private LinearLayout containerBuy, containerButtons;

    public MarketAdapter(@NonNull Context context, @NonNull ArrayList<Market> objects) {
        super(context, 0, objects);
        this.markets = objects;
        this.copyMarkets = new ArrayList<>();
        this.copyMarkets.addAll(markets);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Market m = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.market_view, parent, false);

        neighborhood = convertView.findViewById(R.id.txtNeighborhood);
        homeaddress = convertView.findViewById(R.id.txtHomeAddress);
        person = convertView.findViewById(R.id.txtPerson);
        code = convertView.findViewById(R.id.txtCode);
        date = convertView.findViewById(R.id.txtDatetime);

        if (m != null) {
            try {
                neighborhood.setText(m.getMarketNeighborhood());
                homeaddress.setText(m.getMarketHomeAddress());
                person.setText(m.getMarketPersonReceives());
                code.setText(String.valueOf(m.getMarketID()));

                long timestamp = m.getMarketDatetime();
                Date expiry = new Date(timestamp);
                @SuppressLint("SimpleDateFormat") SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");

                date.setText(jdf.format(expiry));
            } catch (Exception ex) {
                System.out.println(" ERRORES " + ex.getMessage());
            }

        }
        return convertView;
    }


    public void filter(String text) {
        text = text.toLowerCase();
        markets.clear();

        if (text.length() == 0) {
            markets.addAll(copyMarkets);
        } else {

            for (Market m : copyMarkets) {
                if (m.getMarketNeighborhood().toLowerCase().contains(text)) {
                    markets.add(m);
                }
            }
        }
        notifyDataSetChanged();
    }
}
