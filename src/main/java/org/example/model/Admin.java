package org.example.model;

public class Admin extends User {
    public Admin(String nome, String email, String senha, String telefone, String cpf) {
        super(nome,email,senha,telefone,cpf,"ADMIN");
    }
}