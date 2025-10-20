package org.example.service;

import org.example.model.User;
import org.example.repository.UserDAO;

import java.sql.SQLException;

public class AuthService {
    private final UserDAO userDAO;

    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User login(String email, String senha) throws SQLException {
        return userDAO.buscarPorEmailESenha(email, senha);
    }
}
