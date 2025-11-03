package org.example.repository;

import org.example.Conexao;
import java.sql.*;
import java.time.LocalDate;

public class PresencaDAO {

    public int registrarPresenca(int turmaId, int alunoId, int professorId, LocalDate dataAvaliacao, boolean presente, String motivo){
        String sql = "INSERT INTO presencas (turma_id, aluno_id, professor_id, data_avaliacao, presente, motivo) VALUES (?,?,?,?,?,?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, turmaId);
            ps.setInt(2, alunoId);
            ps.setInt(3, professorId);
            ps.setDate(4, Date.valueOf(dataAvaliacao));
            ps.setBoolean(5, presente);
            ps.setString(6, motivo);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);

        } catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}
