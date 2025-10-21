import org.example.Conexao;
import org.example.model.Presenca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PresencaDAO {

    public void saveOrUpdate(Presenca p) throws SQLException {
        // tenta inserir, se violar UNIQUE (aluno_id, unidade_curricular_id, data_avaliacao) então atualiza
        String insert = "INSERT INTO Presenca (aluno_id, unidade_curricular_id, data_avaliacao, status, professor_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(insert)) {
            stmt.setInt(1, p.getAlunoId());
            stmt.setInt(2, p.getUnidadeCurricularId());
            stmt.setDate(3, p.getDataAvaliacao());
            stmt.setString(4, p.getStatus());
            stmt.setInt(5, p.getProfessorId());
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            String update = "UPDATE Presenca SET status = ?, professor_id = ?, updated_at = CURRENT_TIMESTAMP WHERE aluno_id = ? AND unidade_curricular_id = ? AND data_avaliacao = ?";
            try (Connection conn = Conexao.conectar();
            PreparedStatement ps2 = conn.prepareStatement(update)) {
                ps2.setString(1, p.getStatus());
                ps2.setInt(2, p.getProfessorId());
                ps2.setInt(3, p.getAlunoId());
                ps2.setInt(4, p.getUnidadeCurricularId());
                ps2.setDate(5, p.getDataAvaliacao());
                ps2.executeUpdate();
            }
        }
    }

    public List<Presenca> findByAlunoAndStatus(int alunoId, String status) throws SQLException {
        String sql = "SELECT * FROM Presenca WHERE aluno_id = ? AND status = ?";
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, alunoId);
            stmt.setString(2, status);
            ResultSet rs = stmt.executeQuery();
            List<Presenca> lista = new ArrayList<>();
            while (rs.next()) {
                // mapear para Presenca
            }
            return lista;
        }
    }
}
