package com.example.tiwaz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tiwaz.R;
import com.google.firebase.auth.FirebaseAuth;

public class Login_activity extends AppCompatActivity {

    private EditText editEmail, editSenha;
    private Button btnLogin, btnRegistrar;
    private TextView txtEsqueceuSenha;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        txtEsqueceuSenha = findViewById(R.id.txtEsqueceuSenha);
        auth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(v -> fazerLogin());
        btnRegistrar.setOnClickListener(v -> startActivity(new Intent(this, Cadastro_activity.class)));
        txtEsqueceuSenha.setOnClickListener(v -> startActivity(new Intent(this, RecuperarSenha_activity.class)));
    }

    private void fazerLogin() {
        String email = editEmail.getText().toString().trim();
        String senha = editSenha.getText().toString().trim();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(senha)) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.signInWithEmailAndPassword(email, senha)
                .addOnSuccessListener(authResult -> {
                    Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, Main_activity.class));
                    finish();
                })
                .addOnFailureListener(e ->
                        Toast.makeText(this, "Erro no login: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }
}
