package org.example.view;

import org.example.model.Notificacao;
import org.example.model.User;
import org.example.service.NotificationService;

import java.util.List;
import java.util.Scanner;

public class AlunoView {
    private static final Scanner SC = new Scanner(System.in);
    private final NotificationService notificationService = new NotificationService();

    public void menuAluno(User user) {
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
                case 1 -> verNotificacoes(user.getId());
                case 2 -> marcarComoLida();
                case 3 -> sair = true;
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void verNotificacoes(int alunoId) {
        List<Notificacao> notificacoes = notificationService.listarNotificacoes(alunoId);
        if (notificacoes.isEmpty()) {
            System.out.println("Você não possui notificações.");
        } else {
            for (Notificacao n : notificacoes) {
                System.out.println("[" + n.getCreatedAt() + "] " + n.getMensagem() +
                        " | Lida: " + (n.isLida() ? "Sim" : "Não"));
            }
        }
    }

    private void marcarComoLida() {
        System.out.print("Informe o ID da notificação a marcar como lida: ");
        int id = SC.nextInt();
        SC.nextLine();
        notificationService.marcarComoLida(id);
        System.out.println("Notificação marcada como lida!");
    }
}
