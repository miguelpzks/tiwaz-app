package com.example.tiwaz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiwaz.R;
import com.example.tiwaz.models.Produto;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder> {

    private List<Produto> listaProdutos;
    private Context context;

    public ProdutoAdapter(List<Produto> listaProdutos, Context context) {
        this.listaProdutos = listaProdutos;
        this.context = context;
    }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_produto, parent, false);
        return new ProdutoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {
        Produto produto = listaProdutos.get(position);
        holder.txtNome.setText(produto.getNome());
        holder.txtPreco.setText(String.format("R$ %.2f", produto.getPreco()));
        holder.imgProduto.setImageResource(produto.getImagemResId());

        // Espaço para abrir as informaçoes do produto
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    public static class ProdutoViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduto;
        TextView txtNome, txtPreco;

        public ProdutoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduto = itemView.findViewById(R.id.imgProduto);
            txtNome = itemView.findViewById(R.id.txtNomeProduto);
            txtPreco = itemView.findViewById(R.id.txtPrecoProduto);
        }
    }
}
