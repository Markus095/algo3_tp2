package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SopresaDesfavorableTest {
    @Test
    public void reaccionarAUnaSorpresaDesfavorableConTipoDeVehiculoMotoAumentaLosMovimientosEnUn25Porciento(){
        TipoVehiculo moto = new Moto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaDesfavorable sorpresa = new SorpresaDesfavorable();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, moto,mov), 13); // Redondea para arriba
    }

    @Test
    public void reaccionarAUnaSorpresaDesfavorableConTipoDeVehiculoAutoAumentaLosMovimientosEnUn25Porciento(){
        TipoVehiculo auto = new Auto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaDesfavorable sorpresa = new SorpresaDesfavorable();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, auto,mov), 13); // Redondea para arriba
    }

    @Test
    public void reaccionarAUnaSorpresaDesfavorableConTipoDeVehiculo4x4AumentaLosMovimientosEnUn25Porciento(){
        TipoVehiculo camioneta = new CuatroPorCuatro();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaDesfavorable sorpresa = new SorpresaDesfavorable();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, camioneta,mov), 13); // Redondea para arriba
    }
}
