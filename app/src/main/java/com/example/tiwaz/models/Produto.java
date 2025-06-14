package com.example.tiwaz.models;

public class Produto {
    private String nome;
    private String descricao;
    private double preco;
    private int imagemResId; // ID da imagem no drawable

    public Produto(String nome, String descricao, double preco, int imagemResId) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagemResId = imagemResId;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getImagemResId() {
        return imagemResId;
    }
}
