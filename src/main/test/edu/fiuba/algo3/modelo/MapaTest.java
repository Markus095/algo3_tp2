package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

public class MapaTest {

    @Test
    public void unaMotoCruzaLaCiudadYLlegaADestino() {
        Mapa mapa = new Mapa(10, 10);
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Posicion posInicial = new Posicion(1, 0);
        Vehiculo unaMoto = new Vehiculo( moto, posInicial);
        mapa.posicionarVehiculo(unaMoto);
        mapa.asignarDestinoFinal(new Posicion(1, 3));
        Posicion posFinal = posInicial;
        for(int i = 0; i < 3; i++){
            posFinal = mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        }
        assert(mapa.verificarFinDeJuego(posFinal));
    }

    @Test
    public void unAutoCruzaLaCiudadYLlegaADestino() {
        Mapa mapa = new Mapa(10, 10);
        TipoVehiculo auto = new Auto(new Probabilidad(0.5f));
        Posicion posInicial = new Posicion(1, 0);
        Vehiculo unAuto = new Vehiculo( auto, posInicial);
        mapa.posicionarVehiculo(unAuto);
        mapa.asignarDestinoFinal(new Posicion(1, 3));
        Posicion posFinal = posInicial;
        for(int i = 0; i < 3; i++){
            posFinal = mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        }
        assert(mapa.verificarFinDeJuego(posFinal));
    }

    @Test
    public void una4x4CruzaLaCiudadYLlegaADestino() {
        Mapa mapa = new Mapa(10, 10);
        TipoVehiculo camioneta = new CuatroPorCuatro(new Probabilidad(0.3f));
        Posicion posInicial = new Posicion(1, 0);
        Vehiculo unaCamioneta = new Vehiculo( camioneta, posInicial);
        mapa.posicionarVehiculo(unaCamioneta);
        mapa.asignarDestinoFinal(new Posicion(1, 3));

        Posicion posFinal = posInicial;
        for(int i = 0; i < 3; i++){
            posFinal = mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        }
        assert(mapa.verificarFinDeJuego(posFinal));
    }
}
