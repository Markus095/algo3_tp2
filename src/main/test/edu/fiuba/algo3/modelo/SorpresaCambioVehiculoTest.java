package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorpresaCambioVehiculoTest {
    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculoMotoYNoModificaLosMovimientos(){
        TipoVehiculo moto = new Moto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, moto,mov), 10);
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculoAutoYNoModificaLosMovimientos(){
        TipoVehiculo auto = new Auto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, auto,mov), 10);
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculo4x4YNoModificaLosMovimientos(){
        TipoVehiculo camioneta = new CuatroPorCuatro();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, camioneta,mov), 10);
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculoMotoCambiaVehiculoAAuto(){
        Posicion pos = new Posicion(0,0);
        TipoVehiculo moto = new Moto();
        Vehiculo vehiculo = new Vehiculo(moto, pos);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        sorpresa.verificarTipo(vehiculo);
        assert(vehiculo.obtenerTipo().getClass().isInstance(new Auto()));
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculoAutoCambiaVehiculoA4x4(){
        Posicion pos = new Posicion(0,0);
        TipoVehiculo auto = new Auto();
        Vehiculo vehiculo = new Vehiculo(auto, pos);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        sorpresa.verificarTipo(vehiculo);
        assert(vehiculo.obtenerTipo().getClass().isInstance(new CuatroPorCuatro()));
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculo4x4CambiaVehiculoAMoto(){
        Posicion pos = new Posicion(0,0);
        TipoVehiculo camioneta = new CuatroPorCuatro();
        Vehiculo vehiculo = new Vehiculo(camioneta, pos);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        sorpresa.verificarTipo(vehiculo);
        assert(vehiculo.obtenerTipo().getClass().isInstance(new Moto()));
    }

}
