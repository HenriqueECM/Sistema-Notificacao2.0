package org.example.patterns.facade;

import org.example.patterns.factory.UserFactory;
import org.example.repository.TurmaDAO;
import org.example.repository.UnidadeCurricularDAO;
import org.example.repository.UserDAO;
import org.example.model.*;

import java.sql.SQLException;

public class AdminFacade {
    private final UserDAO userDAO = new UserDAO();
    private final TurmaDAO turmaDAO = new TurmaDAO();
    private final UnidadeCurricularDAO curricularDAO = new UnidadeCurricularDAO();

    public int cadastrarAluno(String nome, String email, String senha, String telefone, String cpf, String matricula){
        Aluno a = (Aluno) UserFactory.createUser("ALUNO", nome, email, senha, telefone, cpf, matricula);
        return userDAO.saveUser(a);
    }

    public int cadastrarProfessor(String nome, String email, String senha, String telefone, String cpf){
        Professor p = (Professor) UserFactory.createUser("PROFESSOR", nome, email, senha, telefone, cpf, null);
        return userDAO.saveUser(p);
    }

    public void criarTurma(String nome, String curso){
        turmaDAO.inserir(nome, curso);
    }

    public void criarUC (String nome, String codigo) {
        curricularDAO.create(nome, codigo);
    }
}
