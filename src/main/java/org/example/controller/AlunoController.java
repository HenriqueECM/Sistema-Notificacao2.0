package org.example.controller;

import org.example.model.Notificacao;
import org.example.repository.NotificacaoDAO;

import java.util.List;

public class AlunoController {
    private final NotificacaoDAO notificacaoDAO = new NotificacaoDAO();

    public List<Notificacao> listarNotificacoes(int alunoId) {
        return notificacaoDAO.buscarPorAluno(alunoId);
    }

    public void marcarNotificacoesComoLidas(int alunoId) {
        notificacaoDAO.marcarComoLida(alunoId);
    }
}
