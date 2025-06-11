package com.example.tiwaz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

    @Override
    public CategoriaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.activity_item, parent, false);
        return new CategoriaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoriaViewHolder holder, int position) {
        Categoria categoria = categorias.get(position);
        holder.nomeCategoria.setText(categoria.getNome());
        holder.imagemCategoria.setImageResource(categoria.getImagemRes());
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public static class CategoriaViewHolder extends RecyclerView.ViewHolder {
        TextView nomeCategoria;
        ImageView imagemCategoria;

        public CategoriaViewHolder(View itemView) {
            super(itemView);
            nomeCategoria = itemView.findViewById(R.id.nomeCategoria);
            imagemCategoria = itemView.findViewById(R.id.imagemCategoria);
        }
    }
}
