package observer;

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
        notifyObservers();  // Notifica todos os observers quando o estado muda
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(estado);  // Chama o método update() para cada observer
        }
    }
}
