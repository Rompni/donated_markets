package com.edu.unimagdalena.appmoviles.donated_markets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences(getString(R.string.user_shared_preferences), Context.MODE_PRIVATE);

        User user = new User(
            sharedPreferences.getString(getString(R.string.key_username), ""),
            sharedPreferences.getString(getString(R.string.key_password), "")
        );

        Intent i;

        if(!user.isEmpty())
        {
            i = new Intent(this, HomeActivity.class);
        }else {
            i = new Intent(this, LoginActivity.class);
        }

        startActivity(i);
        finish();
    }
}
