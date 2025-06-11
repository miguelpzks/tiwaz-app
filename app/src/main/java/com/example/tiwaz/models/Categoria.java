package com.example.tiwaz.models;

public class Categoria {
    private String nome;
    private int imagemRes;

    public Categoria(String nome, int imagemRes) {
        this.nome = nome;
        this.imagemRes = imagemRes;
    }

    public String getNome() { return nome; }
    public int getImagemRes() { return imagemRes; }
}
