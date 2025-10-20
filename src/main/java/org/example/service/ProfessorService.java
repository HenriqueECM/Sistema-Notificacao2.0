package org.example.service;

import org.example.model.Professor;
import org.example.repository.ProfessorDAO;
import org.example.repository.UserDAO;

import java.sql.SQLException;

public class ProfessorService {
    private final UserDAO userDAO;
    private final ProfessorDAO professorDAO;

    public ProfessorService(UserDAO userDAO, ProfessorDAO professorDAO) {
        this.userDAO = userDAO;
        this.professorDAO = professorDAO;
    }

    public void cadastrarProfessor(Professor prof) throws SQLException {
        prof.setTipo("PROFESSOR");
        int userId = userDAO.criarUser(prof);
        prof.setId(userId);
        professorDAO.criarProfessor(prof);
    }
}
