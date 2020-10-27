package com.edu.unimagdalena.appmoviles.donated_markets.ui.add_donation;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.edu.unimagdalena.appmoviles.donated_markets.Market;
import com.edu.unimagdalena.appmoviles.donated_markets.MarketController;
import com.edu.unimagdalena.appmoviles.donated_markets.R;
import com.edu.unimagdalena.appmoviles.donated_markets.ui.donation_list.DonationListFragment;

import java.sql.Time;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class AddDonationFragment extends Fragment implements View.OnClickListener{
    EditText neighborhood, homeAddress, personReceives, id;
    Button donation_button;
    MarketController marketController;
    Context context;
    Market market;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_donation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = view.getContext();
        marketController = new MarketController(context);

        neighborhood = view.findViewById(R.id.NEIGHBORHOOD);
        homeAddress = view.findViewById(R.id.HOMEADDRESS);
        personReceives = view.findViewById(R.id.PERSONRECEIVES);
        id = view.findViewById(R.id.ID);
        donation_button = view.findViewById(R.id.donation_button);

        donation_button.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.donation_button:
                if(neighborhood.getText().toString().isEmpty() || homeAddress.getText().toString().isEmpty() ||
                   personReceives.getText().toString().isEmpty() || id.getText().toString().isEmpty()){
                    Toast.makeText(context ,"Verifique que los datos no se encuentren vacios", Toast.LENGTH_LONG).show();
                }else{
                    long time = System.currentTimeMillis();
                    market = new Market(Integer.parseInt(id.getText().toString()), neighborhood.getText().toString(),
                                        homeAddress.getText().toString(), time,
                                        personReceives.getText().toString());
                    if(marketController.getMarket(market.getMarketID()) != null){
                        Toast.makeText(context,"El mercado ya se encuentra registrado", Toast.LENGTH_LONG).show();
                    }else{
                        marketController.addMarket(market);

                    }
                }
                break;
        }
    }
}