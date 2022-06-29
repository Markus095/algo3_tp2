package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CuatroPorCuatroTest {
    /*
    @Test
    public void cuatroPorCuatroReaccionaAPozoSinAumentarLosMovimientos(){
        TipoVehiculo cuatroPorCuatro = new CuatroPorCuatro(new Probabilidad(0.3f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        int cantMovimientos = 0;
        assertEquals(cuatroPorCuatro.reaccionarAPozo(cantMovimientos, mov), 0);
    }

    @Test
    public void cuatroPorCuatroReaccionaATresPozosYAumentaLosMovimientosEnDos(){
        TipoVehiculo cuatroPorCuatro = new CuatroPorCuatro(new Probabilidad(0.3f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        int cantMovimientos = 0;
        cantMovimientos = cuatroPorCuatro.reaccionarAPozo(cantMovimientos, mov);
        cantMovimientos = cuatroPorCuatro.reaccionarAPozo(cantMovimientos, mov);
        assertEquals(cuatroPorCuatro.reaccionarAPozo(cantMovimientos, mov), 2);
    }


    @Test
    public void cuatroPorCuatroReaccionaAPiqueteSinDejarloPasar(){
        TipoVehiculo cuatroPorCuatro = new CuatroPorCuatro(new Probabilidad(0.3f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        int cantMovimientos = 0;
        cuatroPorCuatro.reaccionarAPiquete(cantMovimientos, mov);
        assertFalse(mov.puedeAvanzar());
    }

    @Test
    public void cuatroPorCuatroReaccionaAPiqueteSinAumentarCantidadDeMovimientos(){
        TipoVehiculo cuatroPorCuatro = new CuatroPorCuatro(new Probabilidad(0.3f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        int cantMovimientos = 0;
        cantMovimientos = cuatroPorCuatro.reaccionarAPiquete(cantMovimientos, mov);
        assertEquals(cantMovimientos, 0);
    }

    @Test
    public void cuatroPorCuatroReaccionaASorpresaCambioDeVehiculoYCambiaAMoto(){
        TipoVehiculo cuatroPorCuatro = new CuatroPorCuatro(new Probabilidad(0.3f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        assert(cuatroPorCuatro.cambioVehiculo().getClass().isInstance(new Moto(new Probabilidad(0.8f))));
    }
     */
}
