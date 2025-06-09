package com.example.tiwaz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tiwaz.R;
import com.google.firebase.auth.FirebaseAuth;

public class Main_activity extends AppCompatActivity {

    private Button btnPerfil, btnProdutos, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPerfil = findViewById(R.id.btnPerfil);
        btnProdutos = findViewById(R.id.btnProdutos);
        btnSair = findViewById(R.id.btnSair);

        btnPerfil.setOnClickListener(v -> {
            // ainda sera criado
        });

        btnProdutos.setOnClickListener(v -> {
            // ainda sera criado
        });

        btnSair.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, Login_activity.class));
            finish();
        });
    }
}
