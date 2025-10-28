package org.example.controller;

import org.example.patterns.facade.AdminFacade;

public class CadastroController {
    private final AdminFacade adminFacade = new AdminFacade();

    public void cadastrarProfessor(String nome, String email, String senha, String telefone, String cpf){
        int id = adminFacade.cadastrarProfessor(nome, email, senha, telefone, cpf);
        if (id > 0) {
            System.out.println("Professor cadastrado com id: " + id);
        } else {
            System.out.println("Erro ao cadastrar professor.");
        }
    }

    public void cadastrarAluno(String nome, String email, String senha, String telefone, String cpf, String matricula){
        int alunoId = adminFacade.cadastrarAluno(nome, email, senha, telefone, cpf, matricula);
        if (alunoId > 0) {
            System.out.println("Aluno cadastrado e vinculado (id): " + alunoId);
        } else {
            System.out.println("Erro ao cadastrar aluno.");
        }
    }

    public void cadastrarTurma(String nome, String curso){
        adminFacade.criarTurma(nome, curso);
    }

    public void cadastrarUnidadeCurricular (String nome, String codigo){
        adminFacade.criarUC(nome, codigo);
    }


}
