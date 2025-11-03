package org.example.patterns.observer;

import org.example.model.Notificacao;

public interface Observer {
    void update(Notificacao notificacao);
}
