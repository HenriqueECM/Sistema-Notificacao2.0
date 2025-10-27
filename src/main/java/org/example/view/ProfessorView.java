package org.example.view;

import org.example.model.User;
import org.example.service.NotificationService;

import java.util.Scanner;

public class ProfessorView {
    private static final Scanner SC = new Scanner(System.in);
    private final NotificationService notificationService = new NotificationService();

    public void menuProfessor(User professor) {
        boolean sair = false;
        while (!sair) {
            System.out.print("""
    ╔══════════════════════════════════════════════════════════╗
    ║                PAINEL DO PROFESSOR - MENU                ║
    ╠══════════════════════════════════════════════════════════╣
    ║ 1 - VISUALIZAR TURMAS                                    ║
    ║ 2 - REGISTRAR FALTA EM AVALIAÇÃO                         ║
    ║ 3 - SAIR                                                 ║
    ╚══════════════════════════════════════════════════════════╝
    Escolha uma operação do sistema: """);

            int op = SC.nextInt();
            SC.nextLine();

            switch (op) {
                case 1 -> visualizarTurmas();
                case 2 -> registrarFalta();
                case 3 -> sair = true;
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void visualizarTurmas() {
        System.out.println("(Função visualizar turmas - implementar)");
    }

    private void registrarFalta() {
        System.out.print("ID do Aluno ausente: ");
        int alunoId = SC.nextInt(); SC.nextLine();
        System.out.print("Mensagem da notificação (ex: Faltou na avaliação X): ");
        String msg = SC.nextLine();
        notificationService.notificarFalta(alunoId, msg);
    }
}
