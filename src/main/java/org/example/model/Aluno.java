package org.example.model;

public class Aluno extends User {
    private String matricula;
    public Aluno(String nome, String email, String senha, String telefone, String cpf, String matricula) {
        super(nome,email,senha,telefone,cpf,"ALUNO");
        this.matricula = matricula;
    }
    public String getMatricula(){ return matricula; }
}