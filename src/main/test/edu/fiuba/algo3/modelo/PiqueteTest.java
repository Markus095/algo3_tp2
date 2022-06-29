package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PiqueteTest {
    /*
    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculoMotoPermiteAvanzar(){
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        piquete.reaccionar(movimientosPrevios, tipoVehiculo,mov);
        assert(mov.puedeAvanzar());
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculoMotoAumentaDosMovimientos(){
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        assertEquals(piquete.reaccionar(movimientosPrevios, tipoVehiculo,mov), 12);
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculoAutoNoPermiteAvanzar(){
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        piquete.reaccionar(movimientosPrevios, tipoVehiculo,mov);
        assertFalse(mov.puedeAvanzar());
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculoAutoNoAumentaMovimientosPorqueNoPuedePasar(){
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        assertEquals(piquete.reaccionar(movimientosPrevios, tipoVehiculo,mov), 10);
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculo4x4NoPermiteAvanzar(){
        TipoVehiculo tipoVehiculo = new CuatroPorCuatro(new Probabilidad(0.3f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        piquete.reaccionar(movimientosPrevios, tipoVehiculo,mov);
        assertFalse(mov.puedeAvanzar());
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculo4x4NoAumentaMovimientosPorqueNoPuedePasar(){
        TipoVehiculo tipoVehiculo = new CuatroPorCuatro(new Probabilidad(0.3f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        assertEquals(piquete.reaccionar(movimientosPrevios, tipoVehiculo,mov), 10);
    }

     */
}
