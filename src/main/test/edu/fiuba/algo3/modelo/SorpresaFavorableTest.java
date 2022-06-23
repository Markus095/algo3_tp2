package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

public class SorpresaFavorableTest {
    @Test
    public void reaccionarAUnaSorpresaFavorableConTipoDeVehiculoMotoReduceLosMovimientosEnUn20Porciento(){
        TipoVehiculo moto = new Moto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaFavorable sorpresa = new SorpresaFavorable();
        int movimientosPrevios = 10;

        assertEquals(sorpresa.reaccionar(movimientosPrevios, moto,mov), 8);
    }

    @Test
    public void reaccionarAUnaSorpresaFavorableConTipoDeVehiculoAutoReduceLosMovimientosEnUn20Porciento(){
        TipoVehiculo auto = new Auto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaFavorable sorpresa = new SorpresaFavorable();
        int movimientosPrevios = 10;

        assertEquals(sorpresa.reaccionar(movimientosPrevios, auto,mov), 8);
    }

    @Test
    public void reaccionarAUnaSorpresaFavorableConTipoDeVehiculo4x4ReduceLosMovimientosEnUn20Porciento(){
        TipoVehiculo camioneta = new CuatroPorCuatro();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaFavorable sorpresa = new SorpresaFavorable();
        int movimientosPrevios = 10;

        assertEquals(sorpresa.reaccionar(movimientosPrevios, camioneta,mov), 8);
    }
}
