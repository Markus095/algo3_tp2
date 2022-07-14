package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direccion.Direccion;

public interface Observable {
    void agregarObservador(Observer observador);
    void notificarObservadores(Direccion unaDireccion);
}
