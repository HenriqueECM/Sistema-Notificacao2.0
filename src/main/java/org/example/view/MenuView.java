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

    public static void main(String[] args) {
        menuLoginCadastro();
    }

    public static void menuLoginCadastro() {
        boolean sair = false;

        while (!sair) {
            System.out.print("""
                ╔══════════════════════════════════════════════════════════╗
                ║           SISTEMA NOTIFICAÇÃO: MENU PRINCIPAL            ║
                ╠══════════════════════════════════════════════════════════╣
                ║ 1 - CADASTRO PROFESSOR                                   ║
                ║ 2 - CADASTRO ALUNO                                       ║
                ║ 3 - LOGIN                                                ║
                ║ 4 - SAIR                                                 ║
                ╚══════════════════════════════════════════════════════════╝
                Escolha uma operação do sistema: """);

            int escolha = SC.nextInt();
            SC.nextLine(); // consome o ENTER

            switch (escolha) {
                case 1 -> cadastrarProfessor();
                case 2 -> cadastrarAluno();
                case 3 -> login();
                case 4 -> {
                    sair = true;
                    System.out.println("Finalizando o Sistema...");
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarProfessor() {
        System.out.print("Nome: ");
        String nome = SC.nextLine();
        System.out.print("Email: ");
        String email = SC.nextLine();
        System.out.print("Senha: ");
        String senha = SC.nextLine();
        System.out.print("Telefone: ");
        String telefone = SC.nextLine();
        System.out.print("CPF: ");
        String cpf = SC.nextLine();

        cadastroController.cadastrarProfessor(nome, email, senha, telefone, cpf);
    }

    private static void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = SC.nextLine();
        System.out.print("Email: ");
        String email = SC.nextLine();
        System.out.print("Senha: ");
        String senha = SC.nextLine();
        System.out.print("Matrícula: ");
        String matricula = SC.nextLine();
        System.out.print("Turma: ");
        String turma = SC.nextLine();

        cadastroController.cadastrarAluno(nome, email, senha, matricula, turma);
    }

    private static void login() {
        System.out.print("Email: ");
        String email = SC.nextLine();
        System.out.print("Senha: ");
        String senha = SC.nextLine();

        User user = loginController.login(email, senha);

        if (user != null) {
            if ("PROFESSOR".equalsIgnoreCase(user.getTipo())) {
                professorView.menuProfessor();
            } else if ("ALUNO".equalsIgnoreCase(user.getTipo())) {
                alunoView.menuAluno();
            } else {
                System.out.println("Tipo de usuário não reconhecido!");
            }
        }
    }
}
