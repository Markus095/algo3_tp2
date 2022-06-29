package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.jugador.Auto;
import edu.fiuba.algo3.modelo.jugador.Moto;
import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoTest {
    @Test
    public void motoReaccionaAPozoAumentandoEnTresLosMovimientos(){
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        int cantMovimientos = 0;
        assertEquals(tipoVehiculo.reaccionarAPozo(cantMovimientos), 3);
    }

    @Test
    public void motoReaccionaAPiqueteAumentandoEnDosLosMovimientos(){
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        int cantMovimientos = 0;
        assertEquals(tipoVehiculo.reaccionarAPiquete(cantMovimientos), 2);
    }

    @Test
    public void motoReaccionaASorpresaCambioDeVehiculoYCambiaAAuto(){
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        assert(tipoVehiculo.cambioVehiculo().getClass().isInstance(new Auto(new Probabilidad(0.5f))));
    }
}
