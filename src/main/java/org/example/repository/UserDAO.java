package org.example.repository;

import org.example.Conexao;
import org.example.model.*;

import java.sql.*;

public class UserDAO {

    public User findByEmailAndSenha(String email, String senha) {
        String sql = "SELECT * FROM users WHERE email = ? AND senha = ?";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, senha); // em produção: comparar hash!
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String tipo = rs.getString("tipo");
                if ("ALUNO".equals(tipo)) {
                    Aluno a = new Aluno(rs.getString("nome"), email, senha, rs.getString("telefone"), rs.getString("cpf"), rs.getString("matricula"));
                    a.setId(rs.getInt("id"));
                    return a;
                } else if ("PROFESSOR".equals(tipo)) {
                    Professor p = new Professor(rs.getString("nome"), email, senha, rs.getString("telefone"), rs.getString("cpf"));
                    p.setId(rs.getInt("id"));
                    return p;
                } else if ("ADMIN".equals(tipo)) {
                    Admin adm = new Admin(rs.getString("nome"), email, senha, rs.getString("telefone"), rs.getString("cpf"));
                    adm.setId(rs.getInt("id"));
                    return adm;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int saveUser(User user) {
        String sql = "INSERT INTO users (nome,email,senha,telefone,cpf,tipo,matricula) VALUES (?,?,?,?,?,?,?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getNome());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getSenha());
            ps.setString(4, user.getTelefone());
            ps.setString(5, user.getCpf());
            ps.setString(6, user.getTipo());
            if (user instanceof Aluno) ps.setString(7, ((Aluno) user).getMatricula());
            else ps.setNull(7, Types.VARCHAR);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}