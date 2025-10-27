package org.example.service;

import org.example.model.Notificacao;
import org.example.repository.NotificacaoDAO;

import java.util.List;

public class NotificationService {

    private final NotificacaoDAO repository = new NotificacaoDAO();

    public void notificarFalta(int alunoId, String mensagem) {
        Notificacao n = new Notificacao(alunoId, mensagem);
        repository.salvar(n);
        System.out.println("Notificação enviada ao aluno ID " + alunoId);
    }

    public List<Notificacao> listarNotificacoes(int alunoId) {
        return repository.buscarPorAluno(alunoId);
    }

    public void marcarComoLida(int id) {
        repository.marcarComoLida(id);
    }

    public void notifyAluno(Notificacao notificacao) {

    }
}
