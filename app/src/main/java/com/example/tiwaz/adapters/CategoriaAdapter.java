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
import com.example.tiwaz.models.Categoria;

import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> {

    private List<Categoria> categorias;
    private Context context;

    public CategoriaAdapter(List<Categoria> categorias, Context context) {
        this.categorias = categorias;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_categoria, parent, false);
        return new CategoriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        Categoria categoria = categorias.get(position);
        holder.nomeCategoria.setText(categoria.getNome());
        holder.imagemCategoria.setImageResource(categoria.getImagemRes());
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    static class CategoriaViewHolder extends RecyclerView.ViewHolder {
        TextView nomeCategoria;
        ImageView imagemCategoria;

        public CategoriaViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeCategoria = itemView.findViewById(R.id.nomeCategoria);
            imagemCategoria = itemView.findViewById(R.id.imagemCategoria);
        }
    }
}
