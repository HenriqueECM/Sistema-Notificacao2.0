package org.example.controller;

import org.example.repository.UserDAO;
import org.example.model.User;

public class LoginController {
    private final UserDAO userDAO = new UserDAO();

    public User login(String email, String senha){
        User u = userDAO.findByEmailAndSenha(email, senha);
        if (u == null) System.out.println("Credenciais inválidas.");
        return u;
    }
}
