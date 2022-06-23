package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PozoTest {
    @Test
    public void reaccionarAUnPozoConTipoDeVehiculoMotoAumentaTresMovimientos(){
        TipoVehiculo moto = new Moto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Pozo pozo = new Pozo();
        int movimientosPrevios = 10;
        assertEquals(pozo.reaccionar(movimientosPrevios, moto,mov), 13);
    }

    @Test
    public void reaccionarAUnPozoConTipoDeVehiculoAutoAumentaTresMovimientos(){
        TipoVehiculo auto = new Auto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Pozo pozo = new Pozo();
        int movimientosPrevios = 10;
        assertEquals(pozo.reaccionar(movimientosPrevios, auto,mov), 13);
    }

    @Test
    public void reaccionarAUnPozoConTipoDeVehiculo4x4NoAumentaLosMovimientos(){
        TipoVehiculo camioneta = new CuatroPorCuatro();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Pozo pozo = new Pozo();
        int movimientosPrevios = 10;
        assertEquals(pozo.reaccionar(movimientosPrevios, camioneta,mov), 10);
    }

    @Test
    public void reaccionarATresPozosConTipoDeVehiculo4x4AumentaDosMovimientos(){
        TipoVehiculo camioneta = new CuatroPorCuatro();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Pozo pozo = new Pozo();
        int movimientosPrevios = 10;
        pozo.reaccionar(movimientosPrevios, camioneta,mov);
        pozo.reaccionar(movimientosPrevios, camioneta,mov);
        assertEquals(pozo.reaccionar(movimientosPrevios, camioneta,mov), 12);
    }

    @Test
    public void reaccionarACincoPozosConTipoDeVehiculo4x4AumentaSeisMovimientos(){
        TipoVehiculo camioneta = new CuatroPorCuatro();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Pozo pozo = new Pozo();
        int movimientosPrevios = 10;
        pozo.reaccionar(movimientosPrevios, camioneta,mov);
        pozo.reaccionar(movimientosPrevios, camioneta,mov);
        movimientosPrevios = pozo.reaccionar(movimientosPrevios, camioneta,mov);
        movimientosPrevios = pozo.reaccionar(movimientosPrevios, camioneta,mov);
        assertEquals(pozo.reaccionar(movimientosPrevios, camioneta,mov), 16);
    }
}
