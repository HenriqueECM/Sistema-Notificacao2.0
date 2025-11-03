package org.example.repository;

import org.example.Conexao;
import org.example.model.Notificacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificacaoDAO {

    public void salvarNotificacao(int alunoId, String mensagem) {
        String sql = "INSERT INTO notificacoes (aluno_id, mensagem, lida) VALUES (?, ?, FALSE)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, alunoId);
            ps.setString(2, mensagem);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Notificacao> buscarPorAluno(int alunoId) {
        List<Notificacao> notificacoes = new ArrayList<>();
        String sql = "SELECT mensagem, lida FROM notificacoes WHERE aluno_id = ? ORDER BY created_at DESC";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, alunoId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Notificacao n = new Notificacao(alunoId, rs.getString("mensagem"));
                n.setLida(rs.getBoolean("lida"));
                notificacoes.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notificacoes;
    }

    public void marcarComoLida(int alunoId) {
        String sql = "UPDATE notificacoes SET lida = TRUE WHERE aluno_id = ? AND lida = FALSE";
        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, alunoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
