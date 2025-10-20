package org.example.repository;

import org.example.Conexao;
import org.example.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO {
    public void criarAluno(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO Aluno (id, matricula, status, turma) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aluno.getId());
            stmt.setString(2, aluno.getMatricula());
            stmt.setString(3, aluno.getStatus());
            stmt.setString(4, aluno.getTurma());

            stmt.executeUpdate();
        }
    }
}