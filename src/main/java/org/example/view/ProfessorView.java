package org.example.view;

import org.example.controller.ProfessorController;
import org.example.model.User;
import org.example.service.NotificationService;

import java.time.LocalDate;
import java.util.Scanner;

public class ProfessorView {
    private static final Scanner SC = new Scanner(System.in);
    private final ProfessorController controller = new ProfessorController();

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
        controller.buscarTurmas();
    }

    private void registrarFalta() {
        System.out.println("ID da turma: ");
        int turmaId = SC.nextInt();

        System.out.print("ID do Aluno ausente: ");
        int alunoId = SC.nextInt();

        SC.nextLine();

        System.out.println("Motivo da falta: ");
        String motivo = SC.nextLine();

        LocalDate dataAvaliacao = LocalDate.now();

        controller.registrarFalta(turmaId, alunoId, dataAvaliacao, motivo);
    }
}
