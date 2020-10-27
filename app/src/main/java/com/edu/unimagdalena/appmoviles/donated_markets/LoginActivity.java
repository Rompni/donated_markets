package com.edu.unimagdalena.appmoviles.donated_markets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextUsername, editTextPassword;
    Button loginButton;

    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = (EditText) findViewById(R.id.editTextUser);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.user.setUsername(editTextUsername.getText().toString());
        this.user.setPassword(editTextPassword.getText().toString());

        if (!this.user.isEmpty()) {
            SharedPreferences sharedPreferences = this.getSharedPreferences(getString(R.string.user_shared_preferences), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(getString(R.string.key_username), this.user.getUsername());
            editor.putString(getString(R.string.key_password), this.user.getPassword());
            editor.apply();

            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(this, "Los campos no deben estar vacios", Toast.LENGTH_SHORT).show();
        }
    }
}