package org.example.patterns.observer;

import org.example.model.Notificacao;
import java.util.ArrayList;
import java.util.List;

public class NotificacaoSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String mensagem, int destinatarioId) {
        for (Observer o : observers) {
            o.update(mensagem, destinatarioId); // cada observador é notificado
        }
    }
}
