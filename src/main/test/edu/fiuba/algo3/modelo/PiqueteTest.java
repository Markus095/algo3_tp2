package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PiqueteTest {
    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculoMotoPermiteAvanzar(){
        TipoVehiculo moto = new Moto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        piquete.reaccionar(movimientosPrevios, moto,mov);
        assert(mov.puedeAvanzar());
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculoMotoAumentaDosMovimientos(){
        TipoVehiculo moto = new Moto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        assertEquals(piquete.reaccionar(movimientosPrevios, moto,mov), 12);
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculoAutoNoPermiteAvanzar(){
        TipoVehiculo auto = new Auto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        piquete.reaccionar(movimientosPrevios, auto,mov);
        assertFalse(mov.puedeAvanzar());
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculoAutoNoAumentaMovimientosPorqueNoPuedePasar(){
        TipoVehiculo auto = new Auto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        assertEquals(piquete.reaccionar(movimientosPrevios, auto,mov), 10);
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculo4x4NoPermiteAvanzar(){
        TipoVehiculo camioneta = new CuatroPorCuatro();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        piquete.reaccionar(movimientosPrevios, camioneta,mov);
        assertFalse(mov.puedeAvanzar());
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculo4x4NoAumentaMovimientosPorqueNoPuedePasar(){
        TipoVehiculo camioneta = new CuatroPorCuatro();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        assertEquals(piquete.reaccionar(movimientosPrevios, camioneta,mov), 10);
    }
}
