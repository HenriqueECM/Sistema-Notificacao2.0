package org.example.controller;

import org.example.repository.TurmaDAO;

public class AdminController {

    private final TurmaDAO repository = new TurmaDAO();


    public void associarAlunoTurma(int alunoId, int turmaId) {
        repository.associarAlunoTurma(alunoId, turmaId);
    }

    public void associarUcTurma(int turmaId, int ucId) {
        repository.associarUcTurma(turmaId, ucId);
    }
}
