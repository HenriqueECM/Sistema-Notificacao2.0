package org.example.view;

import org.example.controller.CadastroController;
import org.example.controller.LoginController;
import org.example.model.User;

import java.util.Scanner;

public class MenuView {

    private static final Scanner SC = new Scanner(System.in);
    private static final CadastroController cadastroController = new CadastroController();
    private static final LoginController loginController = new LoginController();
    private static final AlunoView alunoView = new AlunoView();
    private static final ProfessorView professorView = new ProfessorView();
    private static final AdminView adminView = new AdminView();

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        boolean sair = false;
        while (!sair) {
            System.out.print("""
                ╔══════════════════════════════════════════════════════════╗
                ║           SISTEMA DE NOTIFICAÇÃO: MENU PRINCIPAL         ║
                ╠══════════════════════════════════════════════════════════╣
                ║ 1 - LOGIN                                                ║
                ║ 2 - SAIR                                                 ║
                ╚══════════════════════════════════════════════════════════╝
                Escolha uma operação do sistema: """);

            int escolha = SC.nextInt();
            SC.nextLine();

            switch (escolha) {
                case 1 -> login();
                case 2 -> {
                    sair = true;
                    System.out.println("Finalizando o Sistema...");
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void login() {
        System.out.print("Email: ");
        String email = SC.nextLine();
        System.out.print("Senha: ");
        String senha = SC.nextLine();

        User user = loginController.login(email, senha);

        if (user != null) {
            switch (user.getTipo().toUpperCase()) {
                case "ADMIN" -> adminView.menuAdmin(user);
                case "PROFESSOR" -> professorView.menuProfessor(user);
                case "ALUNO" -> alunoView.menuAluno(user);
                default -> System.out.println("Tipo de usuário não reconhecido!");
            }
        } else {
            System.out.println("Credenciais inválidas!");
        }
    }
}