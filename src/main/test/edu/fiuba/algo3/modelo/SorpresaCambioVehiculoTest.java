package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.entidadesCalle.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorpresaCambioVehiculoTest {
    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculoMotoYNoModificaLosMovimientos(){
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, tipoVehiculo), 10);
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculoAutoYNoModificaLosMovimientos(){
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, tipoVehiculo), 10);
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculo4x4YNoModificaLosMovimientos(){
        TipoVehiculo tipoVehiculo = new CuatroPorCuatro(new Probabilidad(0.3f));
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, tipoVehiculo), 10);
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculoMotoCambiaVehiculoAAuto(){
        Posicion pos = new Posicion(0,0);
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(tipoVehiculo, pos);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        sorpresa.verificarTipo(vehiculo);
        assert(vehiculo.obtenerTipo().getClass().isInstance(new Auto(new Probabilidad(0.5f))));
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculoAutoCambiaVehiculoA4x4(){
        Posicion pos = new Posicion(0,0);
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        Vehiculo vehiculo = new Vehiculo(tipoVehiculo, pos);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        sorpresa.verificarTipo(vehiculo);
        assert(vehiculo.obtenerTipo().getClass().isInstance(new CuatroPorCuatro(new Probabilidad(0.3f))));
    }

    @Test
    public void reaccionarAUnaSorpresaCambioVehiculoConTipoDeVehiculo4x4CambiaVehiculoAMoto(){
        Posicion pos = new Posicion(0,0);
        TipoVehiculo tipoVehiculo = new CuatroPorCuatro(new Probabilidad(0.3f));
        Vehiculo vehiculo = new Vehiculo(tipoVehiculo, pos);
        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        sorpresa.verificarTipo(vehiculo);
        assert(vehiculo.obtenerTipo().getClass().isInstance(new Moto(new Probabilidad(0.8f))));
    }
}
