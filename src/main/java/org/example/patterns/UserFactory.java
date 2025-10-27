package org.example.patterns;

import org.example.model.*;

public class UserFactory {
    public static User createUser(String tipo, String nome, String email, String senha, String telefone, String cpf, String matricula) {
        return switch (tipo.toUpperCase()) {
            case "ADMIN" -> new Admin(nome, email, senha, telefone, cpf);
            case "PROFESSOR" -> new Professor(nome, email, senha, telefone, cpf);
            case "ALUNO" -> new Aluno(nome, email, senha, telefone, cpf, matricula);
            default -> throw new IllegalArgumentException("Tipo inválido: " + tipo);
        };
    }
}
