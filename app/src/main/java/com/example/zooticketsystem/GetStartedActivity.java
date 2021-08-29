package com.example.zooticketsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GetStartedActivity extends AppCompatActivity {

    Button btnSignIn, btnnewaccountcreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        btnSignIn = findViewById(R.id.btn_signin);
        btnnewaccountcreate = findViewById(R.id.btn_new_account_create);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosign = new Intent(GetStartedActivity.this, SignInActivity.class);
                startActivity(gotosign);
            }
        });

        btnnewaccountcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoregitersatu = new Intent(GetStartedActivity.this, RegisterSatuActivity.class);
                startActivity(gotoregitersatu);
            }
        });
    }
}
