package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.entidadesCalle.SorpresaFavorable;
import edu.fiuba.algo3.modelo.jugador.Auto;
import edu.fiuba.algo3.modelo.jugador.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.jugador.Moto;
import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SorpresaFavorableTest {
    @Test
    public void reaccionarAUnaSorpresaFavorableConTipoDeVehiculoMotoReduceLosMovimientosEnUn20Porciento(){
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        SorpresaFavorable sorpresa = new SorpresaFavorable();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, tipoVehiculo), 8);
    }

    @Test
    public void reaccionarAUnaSorpresaFavorableConTipoDeVehiculoAutoReduceLosMovimientosEnUn20Porciento(){
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        SorpresaFavorable sorpresa = new SorpresaFavorable();
        int movimientosPrevios = 10;
        assertEquals(sorpresa.reaccionar(movimientosPrevios, tipoVehiculo), 8);
    }

    @Test
    public void reaccionarAUnaSorpresaFavorableConTipoDeVehiculo4x4ReduceLosMovimientosEnUn20Porciento(){
        TipoVehiculo tipoVehiculo = new CuatroPorCuatro(new Probabilidad(0.3f));
        SorpresaFavorable sorpresa = new SorpresaFavorable();
        int movimientosPrevios = 10;

        assertEquals(sorpresa.reaccionar(movimientosPrevios, tipoVehiculo), 8);
    }
}
