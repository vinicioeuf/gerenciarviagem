package com.gerebia.gerenciarviagem.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String estado;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setEstado(String estado) {
        this.estado = estado;
        notifyObservers();  
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(estado); 
        }
    }
}
