package org.example.view;

public class AlunoView {
    public void menuAluno() {
        boolean sair = false;

        System.out.print("""
                ╔══════════════════════════════════════════════════════════╗
                ║                     MENU ALUNO                           ║
                ╠══════════════════════════════════════════════════════════╣
                ║ 1 - VER FALTAS NAS PROVA                                 ║
                ║ 2 - SAIR                                                 ║
                ╚══════════════════════════════════════════════════════════╝
                Escolha uma operação do sistema: """);
    }
}
