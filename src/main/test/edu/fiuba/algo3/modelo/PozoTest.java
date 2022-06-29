package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.entidadesCalle.Pozo;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.jugador.Auto;
import edu.fiuba.algo3.modelo.jugador.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.jugador.Moto;
import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PozoTest {
    @Test
    public void reaccionarAUnPozoConTipoDeVehiculoMotoAumentaTresMovimientos(){
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Pozo pozo = new Pozo();
        int movimientosPrevios = 10;
        assertEquals(pozo.reaccionar(movimientosPrevios, moto), 13);
    }

    @Test
    public void reaccionarAUnPozoConTipoDeVehiculoAutoAumentaTresMovimientos(){
        TipoVehiculo auto = new Auto(new Probabilidad(0.5f));
        Pozo pozo = new Pozo();
        int movimientosPrevios = 10;
        assertEquals(pozo.reaccionar(movimientosPrevios, auto), 13);
    }

    @Test
    public void reaccionarAUnPozoConTipoDeVehiculo4x4NoAumentaLosMovimientos(){
        TipoVehiculo camioneta = new CuatroPorCuatro(new Probabilidad(0.3f));
        Pozo pozo = new Pozo();
        int movimientosPrevios = 10;
        assertEquals(pozo.reaccionar(movimientosPrevios, camioneta), 10);
    }

    @Test
    public void reaccionarATresPozosConTipoDeVehiculo4x4AumentaDosMovimientos(){
        TipoVehiculo camioneta = new CuatroPorCuatro(new Probabilidad(0.3f));
        Pozo pozo = new Pozo();
        int movimientosPrevios = 10;
        pozo.reaccionar(movimientosPrevios, camioneta);
        pozo.reaccionar(movimientosPrevios, camioneta);
        assertEquals(pozo.reaccionar(movimientosPrevios, camioneta), 12);
    }

    @Test
    public void reaccionarACincoPozosConTipoDeVehiculo4x4AumentaSeisMovimientos(){
        TipoVehiculo camioneta = new CuatroPorCuatro(new Probabilidad(0.3f));
        Pozo pozo = new Pozo();
        int movimientosPrevios = 10;
        pozo.reaccionar(movimientosPrevios, camioneta);
        pozo.reaccionar(movimientosPrevios, camioneta);
        movimientosPrevios = pozo.reaccionar(movimientosPrevios, camioneta);
        movimientosPrevios = pozo.reaccionar(movimientosPrevios, camioneta);
        assertEquals(pozo.reaccionar(movimientosPrevios, camioneta), 16);
    }
}
