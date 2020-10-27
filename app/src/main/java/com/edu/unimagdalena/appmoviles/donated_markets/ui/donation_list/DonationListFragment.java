package com.edu.unimagdalena.appmoviles.donated_markets.ui.donation_list;

import android.app.AlertDialog;
import android.content.Context;
<<<<<<< HEAD
=======
import android.content.Intent;
>>>>>>> da7353bcc5109224574869253796c648cdf5cadf
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
<<<<<<< HEAD
=======
import android.widget.LinearLayout;
>>>>>>> da7353bcc5109224574869253796c648cdf5cadf
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
<<<<<<< HEAD
=======
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
>>>>>>> da7353bcc5109224574869253796c648cdf5cadf

import com.edu.unimagdalena.appmoviles.donated_markets.Market;
import com.edu.unimagdalena.appmoviles.donated_markets.MarketAdapter;
import com.edu.unimagdalena.appmoviles.donated_markets.MarketController;
import com.edu.unimagdalena.appmoviles.donated_markets.R;
<<<<<<< HEAD
=======
import com.edu.unimagdalena.appmoviles.donated_markets.ui.add_donation.AddDonationFragment;
>>>>>>> da7353bcc5109224574869253796c648cdf5cadf

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
<<<<<<< HEAD
=======
import java.util.Locale;
>>>>>>> da7353bcc5109224574869253796c648cdf5cadf

public class DonationListFragment extends Fragment {

    ListView mklist;
    MarketController mc;
    ArrayList<Market> arrayOfMarkets;
<<<<<<< HEAD
    MarketAdapter adapter;
    EditText search;
    Context c;


=======
    EditText search;
    Market m;
    Context c;
>>>>>>> da7353bcc5109224574869253796c648cdf5cadf
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_donation_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        c = view.getContext();
        mc = new MarketController(c);
<<<<<<< HEAD

        arrayOfMarkets= new ArrayList<>(mc.getAllMarkets());
        adapter = new MarketAdapter(c, arrayOfMarkets);
        mklist = view.findViewById(R.id.marketList);
        mklist.setAdapter(adapter);

        search = view.findViewById(R.id.neighborhood_find);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adapter.filter(s.toString());
                //adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


=======
        long time = System.currentTimeMillis();

        m = new Market(500, "Santa Cruz", "Calle 47B",
                time, "Julio Mario");

        if (mc.getMarket(m.getMarketID()) == null)
            mc.addMarket(m);

        arrayOfMarkets= new ArrayList<>(mc.getAllMarkets());
        final MarketAdapter adapter = new MarketAdapter(c, arrayOfMarkets);
        mklist = view.findViewById(R.id.marketList);
        mklist.setAdapter(adapter);

>>>>>>> da7353bcc5109224574869253796c648cdf5cadf
        mklist.setClickable(true);
        mklist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView code = view.findViewById(R.id.txtCode);
                TextView neigh = view.findViewById(R.id.txtNeighborhood);
                TextView homeAddress = view.findViewById(R.id.txtHomeAddress);
                TextView person = view.findViewById(R.id.txtPerson);
                TextView date = view.findViewById(R.id.txtDatetime);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
                Date dateTime = null;
                try {
                    dateTime = simpleDateFormat.parse(date.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Market marketI = new Market(Integer.parseInt(code.getText().toString()),neigh.getText().toString(),
                                            homeAddress.getText().toString(),dateTime.getTime(),person.getText().toString());
                mostrarDialogoPersonalizado(marketI);
            }
        });

<<<<<<< HEAD

=======
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
>>>>>>> da7353bcc5109224574869253796c648cdf5cadf
    }

    private void mostrarDialogoPersonalizado(final Market market){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.modal_item_market_list,null);
        TextView textCode = view.findViewById(R.id.text_title);

        textCode.setText("Itém code: " + market.getMarketID());
        builder.setView(view);

        //TODO BOTONES POR DEFECTO
        /**
         builder.setView(inflater.inflate(R.layout.dialog_personalizado,null))
         .setPositiveButton("Reintentar", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getApplicationContext(),"Conectando...",Toast.LENGTH_SHORT).show();
        }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT).show();
        }
        });
         */

        final AlertDialog dialog = builder.create();
        dialog.show();


        /*Button btnReintentar = view.findViewById(R.id.btnReintentar);
        btnReintentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Conectando...",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });*/

        Button btnUpdate = view.findViewById(R.id.button_update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                modalUpdate(market);
<<<<<<< HEAD

=======
>>>>>>> da7353bcc5109224574869253796c648cdf5cadf
            }
        });

        Button btnDelete = view.findViewById(R.id.button_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mc.deleteMarket(market);
<<<<<<< HEAD
                adapter.notifyDataSetChanged();
                arrayOfMarkets= new ArrayList<>(mc.getAllMarkets());
                adapter = new MarketAdapter(c, arrayOfMarkets);
=======
                arrayOfMarkets= new ArrayList<>(mc.getAllMarkets());
                final MarketAdapter adapter = new MarketAdapter(c, arrayOfMarkets);
>>>>>>> da7353bcc5109224574869253796c648cdf5cadf
                mklist.setAdapter(adapter);
                dialog.dismiss();
            }
        });
    }


    private void modalUpdate(final Market market){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.modal_update_item,null);

        final EditText neighborhood, homeAddress, personReceives, id;
        Button donation_button;

        neighborhood = view.findViewById(R.id.NEIGHBORHOOD_edit);
        homeAddress = view.findViewById(R.id.HOMEADDRESS_edit);
        personReceives = view.findViewById(R.id.PERSONRECEIVES_edit);
        id = view.findViewById(R.id.ID_edit);

        neighborhood.setText(market.getMarketNeighborhood());
        homeAddress.setText(market.getMarketHomeAddress());
        personReceives.setText(market.getMarketPersonReceives());
        id.setText(String.valueOf(market.getMarketID()));

        donation_button = view.findViewById(R.id.donation_button_edit);

        builder.setView(view);

        final AlertDialog dialog = builder.create();
        dialog.show();


        donation_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(neighborhood.getText().toString().isEmpty() || homeAddress.getText().toString().isEmpty() ||
                        personReceives.getText().toString().isEmpty() || id.getText().toString().isEmpty()){
                    Toast.makeText(c ,"Verifique que los datos no se encuentren vacios", Toast.LENGTH_LONG).show();
                }else{
                    long time = System.currentTimeMillis();
                    Market marketEdit = new Market(Integer.parseInt(id.getText().toString()), neighborhood.getText().toString(),
                            homeAddress.getText().toString(), time,
                            personReceives.getText().toString());
                    mc.updateMarket(marketEdit);
<<<<<<< HEAD
                    adapter.notifyDataSetChanged();
                    arrayOfMarkets= new ArrayList<>(mc.getAllMarkets());
                    adapter = new MarketAdapter(c, arrayOfMarkets);
                    mklist.setAdapter(adapter);

=======
                    arrayOfMarkets= new ArrayList<>(mc.getAllMarkets());
                    final MarketAdapter adapter = new MarketAdapter(c, arrayOfMarkets);
                    mklist.setAdapter(adapter);
>>>>>>> da7353bcc5109224574869253796c648cdf5cadf
                    dialog.dismiss();
                }
            }
        });

    }
}