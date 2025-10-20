package org.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Presenca {
    private int id, alunoId, unidadeCurricularId, professorId;
    private LocalDate dataAvaliacao;
    private LocalDateTime createdAt, updatedAt;
    private String status;

    public Presenca(int id, int alunoId, int unidadeCurricularId, int professorId, LocalDate dataAvaliacao, LocalDateTime createdAt, LocalDateTime updatedAt, String status) {
        this.id = id;
        this.alunoId = alunoId;
        this.unidadeCurricularId = unidadeCurricularId;
        this.professorId = professorId;
        this.dataAvaliacao = dataAvaliacao;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Presenca(int alunoId, int unidadeCurricularId, int professorId, LocalDate dataAvaliacao, LocalDateTime createdAt, LocalDateTime updatedAt, String status) {
        this.alunoId = alunoId;
        this.unidadeCurricularId = unidadeCurricularId;
        this.professorId = professorId;
        this.dataAvaliacao = dataAvaliacao;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
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

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}