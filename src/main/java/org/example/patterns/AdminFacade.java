package org.example.patterns;

import org.example.repository.TurmaDAO;
import org.example.repository.UserDAO;
import org.example.patterns.UserFactory;
import org.example.model.*;

public class AdminFacade {
    private final UserDAO userDAO = new UserDAO();
    private final TurmaDAO turmaDAO = new TurmaDAO();

    public int cadastrarAluno(String nome, String email, String senha, String telefone, String cpf, String matricula){
        Aluno a = (Aluno) UserFactory.createUser("ALUNO", nome, email, senha, telefone, cpf, matricula);
        return userDAO.saveUser(a);
    }

    public int cadastrarProfessor(String nome, String email, String senha, String telefone, String cpf){
        Professor p = (Professor) UserFactory.createUser("PROFESSOR", nome, email, senha, telefone, cpf, null);
        return userDAO.saveUser(p);
    }

    public int criarTurma(String nome, int unidadeId){
        return turmaDAO.save(new Turma(nome, unidadeId));
    }

}
