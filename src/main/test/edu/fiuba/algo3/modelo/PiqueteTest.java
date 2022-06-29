package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.entidadesCalle.Piquete;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.jugador.Auto;
import edu.fiuba.algo3.modelo.jugador.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.jugador.Moto;
import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PiqueteTest {

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculoMotoPermiteAvanzar(){
        Posicion pos = new Posicion(0,0);
        Direccion dir = DireccionDerecha.getDireccionDerecha();
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        Piquete piquete = new Piquete();
        Posicion posSiguiente = piquete.posicionSiguiente(pos,dir, tipoVehiculo);
        assert(posSiguiente.esIgual(new Posicion(0,1)));
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculoMotoAumentaDosMovimientos(){
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        assertEquals(piquete.reaccionar(movimientosPrevios, tipoVehiculo), 12);
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculoAutoNoPermiteAvanzar(){
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Piquete piquete = new Piquete();
        Posicion posSiguente = piquete.posicionSiguiente(pos,der,tipoVehiculo);
        assert(posSiguente.esIgual(pos));
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculoAutoNoAumentaMovimientosPorqueNoPuedePasar(){
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        assertEquals(piquete.reaccionar(movimientosPrevios, tipoVehiculo), 10);
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculo4x4NoPermiteAvanzar(){
        TipoVehiculo tipoVehiculo = new CuatroPorCuatro(new Probabilidad(0.3f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Piquete piquete = new Piquete();
        Posicion posSiguiente = piquete.posicionSiguiente(pos,der,tipoVehiculo);
        assert(posSiguiente.esIgual(pos));
    }

    @Test
    public void reaccionarAUnPiqueteConTipoDeVehiculo4x4NoAumentaMovimientosPorqueNoPuedePasar(){
        TipoVehiculo tipoVehiculo = new CuatroPorCuatro(new Probabilidad(0.3f));
        Piquete piquete = new Piquete();
        int movimientosPrevios = 10;
        assertEquals(piquete.reaccionar(movimientosPrevios, tipoVehiculo), 10);
    }
}
