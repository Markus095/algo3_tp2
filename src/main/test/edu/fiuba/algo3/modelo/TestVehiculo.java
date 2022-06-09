package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVehiculo {
    @Test
    public void unaMotoCruzaLaCiudadYLlegaADestino() {
        Mapa mapa = new Mapa(10);
        Posicion unaPosicion = mapa.obtenerPosicion(1, 1);
        Moto unaMoto = new Moto(unaPosicion);
        int cero = mapa.asignarPosicionDestino(1, 9);
        boolean estado = mapa.moverVehiculoEnDireccion(unaMoto, 'D');
        estado = mapa.moverVehiculoEnDireccion(unaMoto, 'D');
        estado = mapa.moverVehiculoEnDireccion(unaMoto, 'D');
        estado = mapa.moverVehiculoEnDireccion(unaMoto, 'D');

        assertEquals(true, estado);
    }


}



