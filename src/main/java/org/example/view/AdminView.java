package org.example.view;

import org.example.controller.AdminController;
import org.example.controller.CadastroController;
import org.example.model.User;
import java.util.Scanner;

public class AdminView {
    private static final Scanner SC = new Scanner(System.in);
    private final CadastroController cadastroController = new CadastroController();
    private final AdminController adminController = new AdminController();

    public void menuAdmin(User admin) {
        boolean sair = false;
        while (!sair) {
            System.out.print("""
    ╔══════════════════════════════════════════════════════════╗
    ║               PAINEL ADMINISTRATIVO - MENU               ║
    ╠══════════════════════════════════════════════════════════╣
    ║ 1 - CADASTRAR PROFESSOR                                  ║
    ║ 2 - CADASTRAR ALUNO                                      ║
    ║ 3 - CADASTRAR TURMA                                      ║
    ║ 4 - CADASTRAR UNIDADE CURRICULAR                         ║
    ║ 5 - ASSOCIAR ALUNO À TURMA                               ║
    ║ 6 - ASSOCIAR UNIDADE CURRICULAR À TURMA                  ║
    ║ 7 - SAIR                                                 ║
    ╚══════════════════════════════════════════════════════════╝
    Escolha uma operação do sistema: """);

            int op = SC.nextInt();
            SC.nextLine();

            switch (op) {
                case 1 -> cadastrarProfessor();
                case 2 -> cadastrarAluno();
                case 3 -> cadastrarTurma();
                case 4 -> cadastrarUnidadeCurricular();
                case 5 -> associarAlunoTurma();
                case 6 -> associarUcTurma();
                case 7 -> sair = true;
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarProfessor() {
        System.out.print("Nome: "); String nome = SC.nextLine();
        System.out.print("Email: "); String email = SC.nextLine();
        System.out.print("Senha: "); String senha = SC.nextLine();
        System.out.print("Telefone: "); String tel = SC.nextLine();
        System.out.print("CPF: "); String cpf = SC.nextLine();

        cadastroController.cadastrarProfessor(nome, email, senha, tel, cpf);
    }

    private void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = SC.nextLine();
        System.out.print("Email: ");
        String email = SC.nextLine();
        System.out.print("Senha: ");
        String senha = SC.nextLine();
        System.out.print("Telefone: ");
        String tel = SC.nextLine();
        System.out.print("CPF: ");
        String cpf = SC.nextLine();
        System.out.print("Matrícula: ");
        String matricula = SC.nextLine();

        cadastroController.cadastrarAluno(nome, email, senha, tel, cpf, matricula);
    }

    private void cadastrarTurma() {
        System.out.print("Nome da Turma: ");
        String nome = SC.nextLine();
        System.out.print("Nome do curso: ");
        String curso = SC.nextLine();

        cadastroController.cadastrarTurma(nome, curso);
    }

    private void cadastrarUnidadeCurricular() {
        System.out.println("Nome da Unidade Curricular: ");
        String nome = SC.nextLine();

        System.out.println("Código da UC: ");
        String codigo = SC.nextLine();

        cadastroController.cadastrarUnidadeCurricular(nome, codigo);

    }

    private void associarAlunoTurma() {
        System.out.println("Digite id da turma: ");
        int idTurma = SC.nextInt();

        System.out.println("Digite id do aluno: ");
        int idAluno = SC.nextInt();

        adminController.associarAlunoTurma(idAluno, idTurma);
    }

    private void associarUcTurma() {
        System.out.println("Digite id da turma: ");
        int idTurma = SC.nextInt();

        System.out.println("Digite id da unidade curricular ");
        int idUc = SC.nextInt();

        adminController.associarUcTurma(idTurma, idUc);
    }

}
