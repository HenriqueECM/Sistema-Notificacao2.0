package org.example.controller;

import org.example.model.Turma;
import org.example.repository.PresencaDAO;
import org.example.repository.ProfessorDAO;
import org.example.repository.TurmaDAO;
import org.example.service.NotificationService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ProfessorController {
    private final PresencaDAO presencaDAO = new PresencaDAO();
    private final TurmaDAO turmaDAO = new TurmaDAO();
    private final NotificationService notificationService = new NotificationService();

    public void registrarFalta(int turmaId, int alunoId,int professorId, LocalDate dataAvaliacao, String motivo) {
        int id = presencaDAO.registrarPresenca(turmaId, alunoId, professorId, dataAvaliacao, false, motivo);
        if (id > 0) {
            String mensagem = "\nVocê foi marcado ausente na avaliação do dia " + dataAvaliacao + " na turma " + turmaId;

            notificationService.adicionarObserverAluno(alunoId);
            notificationService.notificarFalta(alunoId, mensagem);

            System.out.println("\nFalta registrada e notificação enviada ao aluno (ID " + alunoId + ")");
        } else {
            System.out.println("Erro ao registrar falta.");
        }
    }

    public void buscarTurmas () {
        List<Turma> turmaList = turmaDAO.findAll();
        for (Turma turma : turmaList){
            System.out.println("id: "  + turma.getId() + " | nome: " + turma.getNome() + " | curso: " + turma.getCurso());
        }
    }
}
