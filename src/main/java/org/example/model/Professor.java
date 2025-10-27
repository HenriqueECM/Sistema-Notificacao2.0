package org.example.model;

public class Professor extends User {
    public Professor(String nome, String email, String senha, String telefone, String cpf) {
        super(nome,email,senha,telefone,cpf,"PROFESSOR");
    }
}