package org.example.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Notificacao {
    private int id;
    private int alunoId;
    private String mensagem;
    private boolean lida;
    private LocalDateTime createdAt;

    public Notificacao(int alunoId, String mensagem) {
        this.alunoId = alunoId;
        this.mensagem = mensagem;
        this.lida = false;
        this.createdAt = LocalDateTime.now();
    }

    public Notificacao(int id, int alunoId, String mensagem, boolean lida, Timestamp createdAt) {
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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
