package com.example.tiwaz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiwaz.R;
import com.example.tiwaz.adapters.CategoriaAdapter;
import com.example.tiwaz.models.Categoria;

import java.util.ArrayList;
import java.util.List;

public class Main_activity extends AppCompatActivity {

    private RecyclerView recyclerCategorias;
    private List<Categoria> listaCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);

        recyclerCategorias = findViewById(R.id.recyclerCategorias);

        listaCategorias = new ArrayList<>();
        listaCategorias.add(new Categoria("Suplementos", R.drawable.ic_user));
        listaCategorias.add(new Categoria("Estilo Gamer", R.drawable.ic_user));
        listaCategorias.add(new Categoria("Acessórios", R.drawable.ic_user));

        recyclerCategorias.setAdapter(new CategoriaAdapter(listaCategorias, this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_perfil) {
            // abrir perfil
        } else if (item.getItemId() == R.id.menu_config) {
            // abrir config
        } else if (item.getItemId() == R.id.menu_sair) {
            // logout
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
