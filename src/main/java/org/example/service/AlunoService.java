package org.example.service;

import org.example.model.Aluno;
import org.example.repository.AlunoDAO;
import org.example.repository.UserDAO;

import java.sql.SQLException;
import java.util.List;

public class AlunoService {
    private final UserDAO userDAO;
    private final AlunoDAO alunoDAO;

    public AlunoService(UserDAO userDAO, AlunoDAO alunoDAO) {
        this.userDAO = userDAO;
        this.alunoDAO = alunoDAO;
    }

    public void cadastrarAluno(Aluno aluno) throws SQLException {
        // vai selecionar o tipo
        aluno.setTipo("ALUNO");
        // vai criar o user de aluno
        int userId = userDAO.criarUser(aluno);

        aluno.setId(userId);

        aluno.setStatus("PRESENTE");

        alunoDAO.criarAluno(aluno);
    }
}
