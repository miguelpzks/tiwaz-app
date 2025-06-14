package com.example.tiwaz.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiwaz.R;
import com.example.tiwaz.adapters.CategoriaAdapter;
import com.example.tiwaz.adapters.ProdutoAdapter;
import com.example.tiwaz.models.Categoria;
import com.example.tiwaz.models.Produto;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Main_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView txtBoasVindas;
    private RecyclerView recyclerCategorias, recyclerProdutos;

    private List<Categoria> listaCategorias;
    private List<Produto> listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarToolbar();
        inicializarDrawer();
        inicializarViews();
        carregarCategorias();
        carregarProdutos();
    }

    private void inicializarToolbar() {
        toolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);
    }

    private void inicializarDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open_drawer,
                R.string.close_drawer
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void inicializarViews() {
        txtBoasVindas = findViewById(R.id.txtBoasVindas);
        txtBoasVindas.setText("Bem-vindo ao Tiwaz Shop!");

        recyclerCategorias = findViewById(R.id.recyclerCategorias);
        recyclerCategorias.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerProdutos = findViewById(R.id.recyclerProdutos);
        recyclerProdutos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void carregarCategorias() {
        listaCategorias = new ArrayList<>();
        listaCategorias.add(new Categoria("Suplementos", R.drawable.ic_user));
        listaCategorias.add(new Categoria("Estilo Gamer", R.drawable.ic_user));
        listaCategorias.add(new Categoria("Acessórios", R.drawable.ic_user));

        CategoriaAdapter categoriaAdapter = new CategoriaAdapter(listaCategorias, this);
        recyclerCategorias.setAdapter(categoriaAdapter);
    }

    private void carregarProdutos() {
        listaProdutos = new ArrayList<>();
        listaProdutos.add(new Produto("Whey Protein", "Suplemento alimentar", 149.90, R.drawable.ic_user));
        listaProdutos.add(new Produto("Creatina", "Ganhe força e volume", 89.90, R.drawable.ic_user));
        listaProdutos.add(new Produto("Pré-treino", "Energia para o treino", 99.90, R.drawable.ic_user));

        ProdutoAdapter produtoAdapter = new ProdutoAdapter(listaProdutos, this);
        recyclerProdutos.setAdapter(produtoAdapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            // Exemplo: voltar pra tela inicial
        } else if (id == R.id.nav_config) {
            // Exemplo: abrir tela de configurações
        } else if (id == R.id.nav_perfil) {
            // Exemplo: abrir tela de perfil
        } else if (id == R.id.nav_sair) {
            finish(); // Sair do app
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
