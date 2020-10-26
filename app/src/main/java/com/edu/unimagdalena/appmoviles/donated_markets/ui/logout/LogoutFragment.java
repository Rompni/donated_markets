package com.edu.unimagdalena.appmoviles.donated_markets.ui.logout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.edu.unimagdalena.appmoviles.donated_markets.LoginActivity;
import com.edu.unimagdalena.appmoviles.donated_markets.R;

import java.util.Objects;

public class LogoutFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_logout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Intent i = new Intent(getContext(), LoginActivity.class);
        requireActivity().startActivity(i);
        requireActivity().finish();
    }
}