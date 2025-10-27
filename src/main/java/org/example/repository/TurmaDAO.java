package org.example.repository;

import org.example.Conexao;
import org.example.model.Turma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {

    public int inserir(Turma turma){
        String sql = "INSERT INTO turmas (nome, unidade_id) VALUES (?,?)";
        try (Connection c = Conexao.conectar(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, turma.getNome());
            ps.setInt(2, turma.getUnidadeId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public List<Turma> findAll(){
        List<Turma> list = new ArrayList<>();
        String sql = "SELECT * FROM turmas";
        try (Connection c = Conexao.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Turma(rs.getInt("id"), rs.getString("nome"), rs.getInt("unidade_id")));
            }
        } catch (SQLException e){ e.printStackTrace(); }
        return list;
    }

    // buscar alunos da turma simplificado (retorna ids)
    public List<Integer> findAlunoIdsByTurma(int turmaId) {
        List<Integer> ids = new ArrayList<>();
        String sql = "SELECT aluno_id FROM turma_alunos WHERE turma_id = ?";
        try (Connection c = Conexao.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, turmaId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) ids.add(rs.getInt("aluno_id"));
        } catch (SQLException e){ e.printStackTrace(); }
        return ids;
    }
}
