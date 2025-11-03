package org.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Presenca {
    private int id, alunoId, unidadeCurricularId;
    private LocalDate dataAvaliacao;
    private String presente, motivo;

    public Presenca(int id, int alunoId, int unidadeCurricularId, LocalDate dataAvaliacao, String presente, String motivo) {
        this.id = id;
        this.alunoId = alunoId;
        this.unidadeCurricularId = unidadeCurricularId;
        this.dataAvaliacao = dataAvaliacao;
        this.presente = presente;
        this.motivo = motivo;
    }

    public Presenca(int alunoId, int unidadeCurricularId, LocalDate dataAvaliacao, String presente, String motivo) {
        this.alunoId = alunoId;
        this.unidadeCurricularId = unidadeCurricularId;
        this.dataAvaliacao = dataAvaliacao;
        this.presente = presente;
        this.motivo = motivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getUnidadeCurricularId() {
        return unidadeCurricularId;
    }

    public void setUnidadeCurricularId(int unidadeCurricularId) {
        this.unidadeCurricularId = unidadeCurricularId;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public String getPresente() {
        return presente;
    }

    public void setPresente(String status) {
        this.presente = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}