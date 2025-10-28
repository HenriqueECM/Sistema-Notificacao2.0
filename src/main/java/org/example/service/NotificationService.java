package org.example.service;

import org.example.model.Notificacao;
import org.example.patterns.observer.AlunoObserver;
import org.example.patterns.observer.NotificacaoSubject;
import org.example.repository.NotificacaoDAO;

import java.util.List;

public class NotificationService {

    private final NotificacaoDAO repository = new NotificacaoDAO();
    private final NotificacaoSubject subject = new NotificacaoSubject();

    public void adicionarObserverAluno(int alunoId) {
        subject.addObserver(new AlunoObserver(alunoId));
    }

    public void notificarFalta(int alunoId, String mensagem) {
        Notificacao n = new Notificacao(alunoId, mensagem);
        repository.salvar(n);
        subject.notifyObservers(n); // dispara evento aos observers
    }

    public List<Notificacao> listarNotificacoes(int alunoId) {
        return repository.buscarPorAluno(alunoId);
    }

    public void marcarComoLida(int id) {
        repository.marcarComoLida(id);
    }
}
