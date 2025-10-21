import org.example.model.Presenca;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class AttendanceController {
    private PresencaDAO presencaDao = new PresencaDAO();
    private final NotificationService notificationService = NotificationService.getInstance(); // singleton opcional

    public void markAbsence(int professorId, int alunoId, int unidadeId, LocalDate dataAvaliacao) {
        try {
            // 1) inserir ou atualizar registro de presença
            Presenca p = new Presenca();
            p.setAlunoId(alunoId);
            p.setUnidadeCurricularId(unidadeId);
            p.setDataAvaliacao(dataAvaliacao);
            p.setStatus("AUSENTE");
            p.setProfessorId(professorId);
            presencaDAO.saveOrUpdate(p); // implementado no DAO: insere se não existir, senão atualiza

            // 2) notificar aluno
            String mensagem = String.format("Você foi marcado como AUSENTE na avaliação de %s (unidade %d).",
                    dataAvaliacao.toString(), unidadeId);

            // Notificação via NotificationService (observer/facade)
            notificationService.notifyAluno(alunoId, mensagem);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Presenca> getAbsencesByAluno(int alunoId) {
        try {
            return presencaDAO.findByAlunoAndStatus(alunoId, "AUSENTE");
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
