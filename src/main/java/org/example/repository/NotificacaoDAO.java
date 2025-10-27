package org.example.repository;

import org.example.Conexao;
import org.example.model.Notificacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificacaoDAO {

    public void salvar(Notificacao n) {
        String sql = "INSERT INTO notificacoes (aluno_id, mensagem, lida, created_at) VALUES (?, ?, ?, NOW())";
        try (Connection c = Conexao.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, n.getAlunoId());
            ps.setString(2, n.getMensagem());
            ps.setBoolean(3, n.isLida());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Notificacao> buscarPorAluno(int alunoId) {
        List<Notificacao> notificacoes = new ArrayList<>();
        String sql = "SELECT * FROM notificacoes WHERE aluno_id = ? ORDER BY created_at DESC";
        try (Connection c = Conexao.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, alunoId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Notificacao n = new Notificacao(
                        rs.getInt("id"),
                        rs.getInt("aluno_id"),
                        rs.getString("mensagem"),
                        rs.getBoolean("lida"),
                        rs.getTimestamp("created_at")
                );
                notificacoes.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notificacoes;
    }

    public void marcarComoLida(int id) {
        String sql = "UPDATE notificacoes SET lida = TRUE WHERE id = ?";
        try (Connection c = Conexao.conectar(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
