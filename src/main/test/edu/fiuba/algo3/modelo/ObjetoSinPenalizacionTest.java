package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.entidadesCalle.ObjetoSinPenalizacion;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.jugador.Auto;
import edu.fiuba.algo3.modelo.jugador.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.jugador.Moto;
import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjetoSinPenalizacionTest {
    @Test
    public void reaccionarAUnPozoConTipoDeVehiculoMotoAumentaTresMovimientos(){
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        ObjetoSinPenalizacion objeto = new ObjetoSinPenalizacion();
        int movimientosPrevios = 10;
        assertEquals(objeto.reaccionar(movimientosPrevios, moto), 10);
    }

    @Test
    public void reaccionarAUnPozoConTipoDeVehiculoAutoAumentaTresMovimientos(){
        TipoVehiculo auto = new Auto(new Probabilidad(0.5f));
        ObjetoSinPenalizacion objeto = new ObjetoSinPenalizacion();
        int movimientosPrevios = 10;
        assertEquals(objeto.reaccionar(movimientosPrevios, auto), 10);
    }

    @Test
    public void reaccionarAUnPozoConTipoDeVehiculo4x4NoAumentaLosMovimientos(){
        TipoVehiculo camioneta = new CuatroPorCuatro(new Probabilidad(0.3f));
        ObjetoSinPenalizacion objeto = new ObjetoSinPenalizacion();
        int movimientosPrevios = 10;
        assertEquals(objeto.reaccionar(movimientosPrevios, camioneta), 10);
    }
}
