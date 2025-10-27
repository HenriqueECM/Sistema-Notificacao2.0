package org.example.controller;

import org.example.patterns.AdminFacade;

public class CadastroController {
    private final AdminFacade adminFacade = new AdminFacade();

    public void cadastrarProfessor(String nome, String email, String senha, String telefone, String cpf){
        int id = adminFacade.cadastrarProfessor(nome, email, senha, telefone, cpf);
        if (id > 0) System.out.println("Professor cadastrado com id: " + id);
        else System.out.println("Erro ao cadastrar professor.");
    }

    public void cadastrarAlunoComTurma(String nome, String email, String senha, String telefone, String cpf, String matricula, int turmaId){
        int alunoId = adminFacade.cadastrarAluno(nome, email, senha, telefone, cpf, matricula);
        if (alunoId > 0) {
            System.out.println("Aluno cadastrado e vinculado (id): " + alunoId);
        } else {
            System.out.println("Erro ao cadastrar aluno.");
        }
    }
}
