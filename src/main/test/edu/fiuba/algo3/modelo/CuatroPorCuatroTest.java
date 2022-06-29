package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.jugador.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.jugador.Moto;
import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuatroPorCuatroTest {
    @Test
    public void cuatroPorCuatroReaccionaAPozoSinAumentarLosMovimientos(){
        TipoVehiculo cuatroPorCuatro = new CuatroPorCuatro(new Probabilidad(0.3f));
        int cantMovimientos = 0;
        assertEquals(cuatroPorCuatro.reaccionarAPozo(cantMovimientos), 0);
    }

    @Test
    public void cuatroPorCuatroReaccionaATresPozosYAumentaLosMovimientosEnDos(){
        TipoVehiculo cuatroPorCuatro = new CuatroPorCuatro(new Probabilidad(0.3f));
        int cantMovimientos = 0;
        cantMovimientos = cuatroPorCuatro.reaccionarAPozo(cantMovimientos);
        cantMovimientos = cuatroPorCuatro.reaccionarAPozo(cantMovimientos);
        assertEquals(cuatroPorCuatro.reaccionarAPozo(cantMovimientos), 2);
    }


    @Test
    public void cuatroPorCuatroReaccionaAPiqueteSinDejarloPasar(){
        TipoVehiculo cuatroPorCuatro = new CuatroPorCuatro(new Probabilidad(0.3f));
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Posicion posSiguiente = cuatroPorCuatro.posicionSiguientePostPiquete(pos,der);
        assert(pos.esIgual(posSiguiente));
    }

    @Test
    public void cuatroPorCuatroReaccionaAPiqueteSinAumentarCantidadDeMovimientos(){
        TipoVehiculo cuatroPorCuatro = new CuatroPorCuatro(new Probabilidad(0.3f));
        int cantMovimientos = 0;
        cantMovimientos = cuatroPorCuatro.reaccionarAPiquete(cantMovimientos);
        assertEquals(cantMovimientos, 0);
    }

    @Test
    public void cuatroPorCuatroReaccionaASorpresaCambioDeVehiculoYCambiaAMoto(){
        TipoVehiculo cuatroPorCuatro = new CuatroPorCuatro(new Probabilidad(0.3f));
        assert(cuatroPorCuatro.cambioVehiculo().getClass().isInstance(new Moto(new Probabilidad(0.8f))));
    }
}
