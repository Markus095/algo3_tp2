package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

public class MapaTest {
    @Test
    //ENTREGA 0:
    // Una moto atraviesa la grilla sin obstáculos y la cantidad de movimientos es X = 3
    public void unaMotoCruzaLaCiudadYLlegaADestino() {
        Mapa mapa = new Mapa(10, 10);
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo unaMoto = new Vehiculo( moto, new Posicion(1, 0));
        mapa.posicionarVehiculo(unaMoto);
        mapa.asignarDestinoFinal(new Posicion(1, 3));

        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assert(mapa.verificarFinDeJuego());
    }

    @Test
    public void unAutoCruzaLaCiudadYLlegaADestino() {
        Mapa mapa = new Mapa(10, 10);
        TipoVehiculo auto = new Auto(new Probabilidad(0.5f));
        Vehiculo unAuto = new Vehiculo( auto, new Posicion(1, 0));
        mapa.posicionarVehiculo(unAuto);
        mapa.asignarDestinoFinal(new Posicion(1, 3));

        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assert(mapa.verificarFinDeJuego());
    }

    @Test
    public void una4x4CruzaLaCiudadYLlegaADestino() {
        Mapa mapa = new Mapa(10, 10);
        TipoVehiculo camioneta = new CuatroPorCuatro(new Probabilidad(0.3f));
        Vehiculo unaCamioneta = new Vehiculo( camioneta, new Posicion(1, 0));
        mapa.posicionarVehiculo(unaCamioneta);
        mapa.asignarDestinoFinal(new Posicion(1, 3));

        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assert(mapa.verificarFinDeJuego());
    }
}
