package org.example.patterns.observer;

public class AlunoObserver implements Observer {
    private final int alunoId;

    public AlunoObserver(int alunoId) {
        this.alunoId = alunoId;
    }

    @Override
    public void update(String mensagem, int destinatarioId) {
        if (this.alunoId == destinatarioId) {
            System.out.println("\n(Nova notificação para aluno ID " + alunoId + "): " + mensagem);
        }
    }
}
