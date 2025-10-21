package org.example.view;

import org.example.model.User;

import java.util.Scanner;

import static org.example.view.MenuView.menuLoginCadastro;

public class AlunoView {
    static Scanner SC = new Scanner(System.in);

    public void menuAluno(User aluno) {
        boolean sair = false;

        System.out.print("""
                ╔══════════════════════════════════════════════════════════╗
                ║                     MENU ALUNO                           ║
                ╠══════════════════════════════════════════════════════════╣
                ║ 1 - VER FALTAS NAS PROVA                                 ║
                ║ 2 - SAIR                                                 ║
                ╚══════════════════════════════════════════════════════════╝
                Escolha uma operação do sistema:""");
        int escolha = SC.nextInt();

        switch (escolha){
            case 1: {

            }
            case 2: {
                sair = true;
                System.out.println("Saindo do menu do aluno...");
                break;
            }
            default: {
                System.out.println("Opção Inválida!");
                break;
            }
        }
        if (!sair){
            menuLoginCadastro();
        }
    }
}
