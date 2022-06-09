package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestVehiculo1 {
    Mapa mapa = new Mapa(10);
    Posicion unaPosicion = mapa.obtenerPosicion(1, 1);
    Moto unaMoto = new Moto(unaPosicion);
    mapa.mover(unaMoto, 'D');
}


