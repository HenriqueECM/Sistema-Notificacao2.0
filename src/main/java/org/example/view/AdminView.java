package org.example.view;

import org.example.controller.CadastroController;
import org.example.controller.TurmaController;
import org.example.model.User;
import java.util.Scanner;

public class AdminView {
    private static final Scanner SC = new Scanner(System.in);
    private final CadastroController cadastroController = new CadastroController();
    private final TurmaController turmaController = new TurmaController();

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
    ║ 4 - ASSOCIAR ALUNO À TURMA                               ║
    ║ 5 - ASSOCIAR UNIDADE CURRICULAR À TURMA                  ║
    ║ 6 - LISTAR PROFESSORES                                   ║
    ║ 7 - LISTAR ALUNOS                                        ║
    ║ 8 - LISTAR TURMAS                                        ║
    ║ 9 - SAIR                                                 ║
    ╚══════════════════════════════════════════════════════════╝
    Escolha uma operação do sistema: """);

            int op = SC.nextInt();
            SC.nextLine();

            switch (op) {
                case 1 -> cadastrarProfessor();
                case 2 -> cadastrarAluno();
                case 3 -> cadastrarTurma();
                case 4 -> associarAlunoTurma();
                case 5 -> associarUcTurma();
                case 6 -> listarProfessores();
                case 7 -> listarAlunos();
                case 8 -> listarTurmas();
                case 9 -> sair = true;
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
        System.out.print("Nome: "); String nome = SC.nextLine();
        System.out.print("Email: "); String email = SC.nextLine();
        System.out.print("Senha: "); String senha = SC.nextLine();
        System.out.print("Telefone: "); String tel = SC.nextLine();
        System.out.print("CPF: "); String cpf = SC.nextLine();
        System.out.print("Matrícula: "); String matricula = SC.nextLine();
        System.out.print("ID Turma (0 para pular): "); int turmaId = SC.nextInt(); SC.nextLine();

        cadastroController.cadastrarAlunoComTurma(nome, email, senha, tel, cpf, matricula, turmaId);
    }

    private void cadastrarTurma() {
        System.out.print("Nome da Turma: "); String nome = SC.nextLine();
        System.out.print("ID Unidade Curricular: "); int unidadeId = SC.nextInt(); SC.nextLine();
        System.out.println("(Função cadastrar turma - implementar via TurmaController)");

        turmaController.cadastrarTurma(nome, unidadeId);
    }

    private void associarAlunoTurma() {
        System.out.println("(Função associar aluno a turma - implementar)");
    }

    private void associarUcTurma() {
        System.out.println("(Função associar unidade curricular a turma - implementar)");
    }

    private void listarProfessores() {
        System.out.println("(Função listar professores - implementar)");
    }

    private void listarAlunos() {
        System.out.println("(Função listar alunos - implementar)");
    }

    private void listarTurmas() {
        System.out.println("(Função listar turmas - implementar)");
    }
}
