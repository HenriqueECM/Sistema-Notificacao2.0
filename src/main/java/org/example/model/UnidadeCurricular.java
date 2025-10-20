package org.example.model;

import java.time.LocalDate;

public class UnidadeCurricular {

    private int id;
    private String nome;
    private LocalDate dataInicio;
    private int idProfessor;

    public UnidadeCurricular(int id, String nome, LocalDate dataInicio, int idProfessor) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.idProfessor = idProfessor;
    }

    public UnidadeCurricular(String nome, LocalDate dataInicio, int idProfessor) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.idProfessor = idProfessor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public int getIdProfessor() {
        return idProfessor;
    }


}
