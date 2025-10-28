package org.example.repository;

import org.example.Conexao;
import org.example.model.Turma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {

    public void inserir(String nome, String curso){
        String sql = "INSERT INTO turmas (nome, curso) VALUES (?,?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, curso);
            stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Turma> findAll(){
        List<Turma> list = new ArrayList<>();
        String sql = "SELECT * FROM turmas";
        try (Connection c = Conexao.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Turma(rs.getInt("id"), rs.getString("nome"), rs.getString("curso")));
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

    public void associarAlunoTurma(int alunoId, int turmaId) {
        String sql = "INSERT INTO turma_alunos (turma_id, aluno_id) VALUES (?, ?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, turmaId);
            ps.setInt(2, alunoId);
            ps.executeUpdate();
            System.out.println("Aluno associado à turma com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void associarUcTurma(int turmaId, int ucId) {
        String sql = "INSERT INTO turma_uc (turma_id, unidadeCurricular_id) VALUES (?, ?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, turmaId);
            ps.setInt(2, ucId);
            ps.executeUpdate();
            System.out.println("Unidade Curricular associada à turma com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
