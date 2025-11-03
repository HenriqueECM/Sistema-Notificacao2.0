package org.example.patterns.observer;

import org.example.model.Notificacao;

public class AlunoObserver implements Observer {
    private final int alunoId;

    public AlunoObserver(int alunoId) {
        this.alunoId = alunoId;
    }

    @Override
    public void update(Notificacao notificacao) {
        if (this.alunoId == notificacao.getAlunoId()) {
            System.out.println("\n(Nova notificação para aluno ID " + alunoId + "): " + notificacao.getMensagem());
        }
    }
}
