package org.example.view;

import org.example.model.Aluno;
import org.example.model.User;
import org.example.repository.AlunoDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static org.example.view.MenuView.menuLoginCadastro;

public class ProfessorView {
    static Scanner SC = new Scanner(System.in);
    public void menuProfessor(User professor) {
        boolean sair = false;

        System.out.print("""
                ╔══════════════════════════════════════════════════════════╗
                ║                     MENU PROFESSOR                       ║
                ╠══════════════════════════════════════════════════════════╣
                ║ 1 - LISTAR ALUNOS                                        ║
                ║ 2 - MARCAR FALTA                                         ║
                ║ 3 - SAIR                                                 ║
                ╚══════════════════════════════════════════════════════════╝
                Escolha uma operação do sistema:""");
        int escolha = SC.nextInt();

        switch (escolha){
            case 1 -> { // Listar alunos
                AlunoDAO alunoDAO = new AlunoDAO();
                List<Aluno> alunos = alunoDAO.findByProfessor();
                alunos.forEach(a -> System.out.printf("%d - %s (%s)\n", a.getId(), a.getNome(), a.getMatricula()));
            }
            case 2 -> { // Marcar falta
                System.out.print("ID do aluno: ");
                int alunoId = SC.nextInt(); SC.nextLine();
                System.out.print("ID da unidade curricular: ");
                int unidadeId = SC.nextInt(); SC.nextLine();
                LocalDate dataAvaliacao = LocalDate.now();
                AttendanceController ac = new AttendanceController();
                ac.markAbsence(professor.getId(), alunoId, unidadeId, Date.valueOf(dataAvaliacao));
                System.out.println("Falta registrada e notificação enviada.");
            }
            case 3 -> {
                sair = true;
                System.out.println("Saindo do menu do professor...");
            }
            default -> System.out.println("Opção inválida");
        }
        if (!sair){
            menuLoginCadastro();
        }
    }
}
