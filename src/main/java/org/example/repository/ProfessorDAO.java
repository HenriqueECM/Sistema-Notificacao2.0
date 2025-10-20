package org.example.repository;

import org.example.Conexao;
import org.example.model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfessorDAO {
    public void criarProfessor(Professor professor) throws SQLException {
        String sql = "INSERT INTO Professor (id, telefone, CPF) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, professor.getId());
            stmt.setString(2, professor.getTelefone());
            stmt.setString(3, professor.getCpf());
            stmt.executeUpdate();
        }
    }
}
