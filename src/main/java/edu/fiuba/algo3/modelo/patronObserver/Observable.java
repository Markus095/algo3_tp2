package edu.fiuba.algo3.modelo.patronObserver;

public interface Observable {
    void agregarObservador(Observer observer);

    void notificarObservadores();
}
