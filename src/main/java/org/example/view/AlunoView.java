package org.example.view;

import org.example.controller.AlunoController;
import org.example.model.Notificacao;
import org.example.model.User;
import org.example.service.NotificationService;

import java.util.List;
import java.util.Scanner;

public class AlunoView {
    private static final Scanner SC = new Scanner(System.in);
    private final NotificationService notificationService = new NotificationService();
    private final AlunoController controller = new AlunoController();


    public void menuAluno(User aluno) {
        boolean sair = false;
        while (!sair) {
            System.out.print("""
    ╔══════════════════════════════════════════════════════════╗
    ║                 PAINEL DO ALUNO - MENU                   ║
    ╠══════════════════════════════════════════════════════════╣
    ║ 1 - VISUALIZAR NOTIFICAÇÕES                              ║
    ║ 2 - MARCAR NOTIFICAÇÃO COMO LIDA                         ║
    ║ 3 - SAIR                                                 ║
    ╚══════════════════════════════════════════════════════════╝
    Escolha uma operação do sistema: """);

            int op = SC.nextInt();
            SC.nextLine();

            switch (op) {
                case 1 -> visualizarNotificacoes(aluno.getId());
                case 2 -> marcarComoLidas(aluno.getId());
                case 3 -> sair = true;
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void visualizarNotificacoes(int alunoId) {
        List<Notificacao> notificacoes = controller.listarNotificacoes(alunoId);

        if (notificacoes.isEmpty()) {
            System.out.println("\nNenhuma notificação encontrada.");
            return;
        }

        System.out.println("\n📢 SUAS NOTIFICAÇÕES:");
        for (Notificacao n : notificacoes) {
            String status = n.isLida() ? "Lida" : "Não lida";
            System.out.println("- " + n.getMensagem() + " | " + status);
        }
    }

    private void marcarComoLidas(int alunoId) {
        controller.marcarNotificacoesComoLidas(alunoId);
        System.out.println("\nTodas as notificações foram marcadas como lidas!");
    }
}
