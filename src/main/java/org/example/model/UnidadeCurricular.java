package org.example.model;

import java.time.LocalDate;

public class UnidadeCurricular {

    private int id;
    private String nome;
    private String codigo;

    public UnidadeCurricular(int id, String nome, String codigo) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
    }

    public UnidadeCurricular(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() { return codigo; }
}
