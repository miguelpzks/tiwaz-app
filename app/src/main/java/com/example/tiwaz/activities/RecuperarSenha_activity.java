package com.example.tiwaz.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tiwaz.R;
import com.google.firebase.auth.FirebaseAuth;
public class RecuperarSenha_activity extends AppCompatActivity {

    private EditText editEmail;
    private Button btnRecuperar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperarsenha);

        editEmail = findViewById(R.id.editEmail);
        btnRecuperar = findViewById(R.id.btnRecuperar);
        auth = FirebaseAuth.getInstance();

        btnRecuperar.setOnClickListener(v -> {
            String email = editEmail.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Digite seu email", Toast.LENGTH_SHORT).show();
                return;
            }

            auth.sendPasswordResetEmail(email)
                    .addOnSuccessListener(unused ->
                            Toast.makeText(this, "Email de recuperacao enviado!", Toast.LENGTH_SHORT).show())
                    .addOnFailureListener(e ->
                            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show());
        });

    }
}
