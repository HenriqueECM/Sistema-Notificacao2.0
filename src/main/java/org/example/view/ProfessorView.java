package org.example.view;

import java.util.Scanner;

import static org.example.view.MenuView.menuLoginCadastro;

public class ProfessorView {
    static Scanner SC = new Scanner(System.in);
    public void menuProfessor() {
        boolean sair = false;

        System.out.print("""
                ╔══════════════════════════════════════════════════════════╗
                ║                     MENU PROFESSOR                       ║
                ╠══════════════════════════════════════════════════════════╣
                ║ 1 - LISTAR ALUNOS                                        ║
                ║ 2 - MARCAR FALTA                                         ║
                ║ 3 - SAIR                                                 ║
                ╚══════════════════════════════════════════════════════════╝
                Escolha uma operação do sistema: """);
        int escolha = SC.nextInt();

        switch (escolha){
            case 1: {

            }
            case 2: {

            }
            case 3: {
                sair = true;
                System.out.println("Saindo do menu do professor...");
                break;
            }
            default: {
                System.out.println("Opção inválida");
                break;
            }
        }
        if (!sair){
            menuLoginCadastro();
        }
    }
}
