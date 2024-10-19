package com.jred.ed.model;

public enum Password {

    MAISCULO("Maísculo"),
    MINUSCULO("Minúsculo"),
    CARACTER_ESPECIAL("Caracter Especial"),
    NUMERICO("Numérico"),
    TAMANHO("A senha é menor que 8 caracteres");

    private String nome;

    public String getNome() {
        return nome;
    }

    Password(String nome) {
        this.nome = nome;
    }
}
