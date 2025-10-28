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
    public void notifyObservers(Notificacao notificacao) {
        for (Observer o : observers) {
            o.update(notificacao); // cada observador é notificado
        }
    }
}
