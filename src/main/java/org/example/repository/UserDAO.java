package org.example.repository;

import org.example.Conexao;
import org.example.model.User;

import java.sql.*;

public class UserDAO {

    public int criarUser(User user) throws SQLException {
        String sql = "INSERT INTO User (nome, email, senha, tipo) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getSenha());
            stmt.setString(4, user.getTipo());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        throw new SQLException("Falha ao criar usuário");
    }

    public User buscarPorEmailESenha(String email, String senha) throws SQLException {
        String sql = "SELECT * FROM User WHERE email = ? AND senha = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, senha);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setNome(rs.getString("nome"));
                    user.setEmail(rs.getString("email"));
                    user.setSenha(rs.getString("senha"));
                    user.setTipo(rs.getString("tipo"));
                    return user;
                }
            }
        }
        return null;
    }
}