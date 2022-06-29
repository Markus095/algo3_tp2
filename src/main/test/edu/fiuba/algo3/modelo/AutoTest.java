package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.jugador.Auto;
import edu.fiuba.algo3.modelo.jugador.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AutoTest {
    @Test
    public void autoReaccionaAPozoAumentandoEnTresLosMovimientos(){
        TipoVehiculo auto = new Auto(new Probabilidad(0.5f));
        int cantMovimientos = 0;
        assertEquals(auto.reaccionarAPozo(cantMovimientos), 3);
    }

    @Test
    public void autoReaccionaAPiqueteSinDejarloPasar(){
        TipoVehiculo auto = new Auto(new Probabilidad(0.5f));
        Posicion posicionAuto = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        assertEquals(posicionAuto, auto.posicionSiguientePostPiquete(posicionAuto, der));
    }

    @Test
    public void autoReaccionaAPiqueteSinAumentarCantidadDeMovimientos(){
        TipoVehiculo auto = new Auto(new Probabilidad(0.5f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        int cantMovimientos = 0;
        cantMovimientos = auto.reaccionarAPiquete(cantMovimientos);
        assertEquals(cantMovimientos, 0);
    }

    @Test
    public void autoReaccionaASorpresaCambioDeVehiculoYCambiaA4x4(){
        TipoVehiculo auto = new Auto(new Probabilidad(0.5f));
        assert(auto.cambioVehiculo().getClass().isInstance(new CuatroPorCuatro(new Probabilidad(0.3f))));
    }
}
