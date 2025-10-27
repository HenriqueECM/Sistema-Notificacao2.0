package org.example.controller;

import org.example.repository.PresencaDAO;
import org.example.service.NotificationService;
import org.example.model.Notificacao;

import java.sql.Date;

public class ProfessorController {
    private final PresencaDAO presencaDAO = new PresencaDAO();
    private final NotificationService notificationService = new NotificationService();

    public void registrarFalta(int turmaId, int alunoId, int professorId, Date dataAvaliacao, String motivo) {
        int id = presencaDAO.registrarPresenca(turmaId, alunoId, professorId, dataAvaliacao, false, motivo);
        if (id > 0) {
            String mensagem = "Você foi marcado ausente na avaliação do dia " + dataAvaliacao.toString() + " na turma " + turmaId;
            notificationService.notifyAluno(new Notificacao(alunoId, mensagem));
            System.out.println("Falta registrada e notificação enviada ao aluno (id " + alunoId + ")");
        } else {
            System.out.println("Erro ao registrar falta.");
        }
    }
}
