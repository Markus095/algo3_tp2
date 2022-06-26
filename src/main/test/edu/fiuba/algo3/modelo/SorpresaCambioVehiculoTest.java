package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorpresaCambioVehiculoTest {
    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculoMotoYNoModificaLosMovimientos(){
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, tipoVehiculo,mov), 10);
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculoAutoYNoModificaLosMovimientos(){
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, tipoVehiculo,mov), 10);
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculo4x4YNoModificaLosMovimientos(){
        TipoVehiculo tipoVehiculo = new CuatroPorCuatro(new Probabilidad(0.3f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, tipoVehiculo,mov), 10);
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculoMotoCambiaVehiculoAAuto(){
        Posicion pos = new Posicion(0,0);
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(tipoVehiculo, pos);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        sorpresa.verificarTipo(vehiculo);
        assert(vehiculo.obtenerTipo().getClass().isInstance(new Auto(new Probabilidad(0.5f))));
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculoAutoCambiaVehiculoA4x4(){
        Posicion pos = new Posicion(0,0);
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        Vehiculo vehiculo = new Vehiculo(tipoVehiculo, pos);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        sorpresa.verificarTipo(vehiculo);
        assert(vehiculo.obtenerTipo().getClass().isInstance(new CuatroPorCuatro(new Probabilidad(0.3f))));
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculo4x4CambiaVehiculoAMoto(){
        Posicion pos = new Posicion(0,0);
        TipoVehiculo tipoVehiculo = new CuatroPorCuatro(new Probabilidad(0.3f));
        Vehiculo vehiculo = new Vehiculo(tipoVehiculo, pos);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        sorpresa.verificarTipo(vehiculo);
        assert(vehiculo.obtenerTipo().getClass().isInstance(new Moto(new Probabilidad(0.8f))));
    }

}
