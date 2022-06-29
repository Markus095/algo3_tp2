package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.entidadesCalle.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.jugador.Auto;
import edu.fiuba.algo3.modelo.jugador.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.jugador.Moto;
import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SopresaDesfavorableTest {
    @Test
    public void reaccionarAUnaSorpresaDesfavorableConTipoDeVehiculoMotoAumentaLosMovimientosEnUn25Porciento(){
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Posicion pos = new Posicion(0,0);
        SorpresaDesfavorable sorpresa = new SorpresaDesfavorable();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, moto), 13); // Redondea para arriba
    }

    @Test
    public void reaccionarAUnaSorpresaDesfavorableConTipoDeVehiculoAutoAumentaLosMovimientosEnUn25Porciento(){
        TipoVehiculo auto = new Auto(new Probabilidad(0.5f));
        Posicion pos = new Posicion(0,0);
        SorpresaDesfavorable sorpresa = new SorpresaDesfavorable();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, auto), 13); // Redondea para arriba
    }

    @Test
    public void reaccionarAUnaSorpresaDesfavorableConTipoDeVehiculo4x4AumentaLosMovimientosEnUn25Porciento(){
        TipoVehiculo camioneta = new CuatroPorCuatro(new Probabilidad(0.3f));
        Posicion pos = new Posicion(0,0);
        SorpresaDesfavorable sorpresa = new SorpresaDesfavorable();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, camioneta), 13); // Redondea para arriba
    }
}
