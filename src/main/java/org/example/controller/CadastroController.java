package org.example.controller;

import org.example.model.Aluno;
import org.example.model.Professor;
import org.example.repository.AlunoDAO;
import org.example.repository.ProfessorDAO;
import org.example.repository.UserDAO;
import org.example.service.AlunoService;
import org.example.service.ProfessorService;

public class CadastroController {
    private final AlunoService alunoService;
    private final ProfessorService professorService;

    public CadastroController() {
        this.alunoService = new AlunoService(new UserDAO(), new AlunoDAO());
        this.professorService = new ProfessorService(new UserDAO(), new ProfessorDAO());
    }

    public void cadastrarAluno(String nome, String email, String senha, String matricula, String turma) {
        try {
            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setEmail(email);
            aluno.setSenha(senha);
            aluno.setMatricula(matricula);
            aluno.setTurma(turma);
            alunoService.cadastrarAluno(aluno);
            System.out.println("Aluno cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

    public void cadastrarProfessor(String nome, String email, String senha, String telefone, String cpf) {
        try {
            Professor prof = new Professor();
            prof.setNome(nome);
            prof.setEmail(email);
            prof.setSenha(senha);
            prof.setTelefone(telefone);
            prof.setCpf(cpf);
            professorService.cadastrarProfessor(prof);
            System.out.println("Professor cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar professor: " + e.getMessage());
        }
    }
}
