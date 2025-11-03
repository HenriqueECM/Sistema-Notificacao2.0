package org.example.patterns.observer;

import org.example.model.Notificacao;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);

    void notifyObservers(Notificacao notificacao);
}
