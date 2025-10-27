package org.example.model;

public class Turma {
    private int id;
    private String nome;
    private int unidadeId;

    public Turma(int id, String nome, int unidadeId) {
        this.id = id;
        this.nome = nome;
        this.unidadeId = unidadeId;
    }

    public Turma(String nome, int unidadeId){
        this.nome = nome;
        this.unidadeId = unidadeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(int unidadeId) {
        this.unidadeId = unidadeId;
    }
}
