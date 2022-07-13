package edu.fiuba.algo3.modelo.direccion;

import edu.fiuba.algo3.modelo.tablero.Posicion;

public interface Direccion {

    void mover(Posicion posicion);

    double obtenerRotacion();

    Posicion obtenerPosicion(Posicion posicion);

}




