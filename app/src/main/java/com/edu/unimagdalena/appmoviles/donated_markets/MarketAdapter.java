package com.edu.unimagdalena.appmoviles.donated_markets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class MarketAdapter extends ArrayAdapter<Market> {

    public MarketAdapter(@NonNull Context context, @NonNull ArrayList<Market> objects) {
        super(context,0, objects);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Market m = getItem(position);

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.market_view, parent, false);

        TextView neighborhood = (TextView) convertView.findViewById(R.id.txtNeighborhood);
        TextView homeaddress = (TextView) convertView.findViewById(R.id.txtHomeAddress);
        TextView person = (TextView) convertView.findViewById(R.id.txtPerson);
        TextView code = (TextView) convertView.findViewById(R.id.txtCode);
        TextView date = (TextView) convertView.findViewById(R.id.txtDatetime);

        if(m != null) {
            try {
                neighborhood.setText(m.getMarketNeighborhood());
                homeaddress.setText(m.getMarketHomeAddress());
                person.setText(m.getMarketPersonReceives());
                code.setText(String.valueOf(m.getMarketID()));

               long timestamp = Long.parseLong(m.getMarketDatetime());
                Date expiry = new Date(timestamp * 1000L);
                @SuppressLint("SimpleDateFormat") SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");

                date.setText(jdf.format(expiry));
            }catch (Exception ex){
                System.out.println( " ERRORES " + ex.getMessage());
            }

        }
        return convertView;
    }
}
