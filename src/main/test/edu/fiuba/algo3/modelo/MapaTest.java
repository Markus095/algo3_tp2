package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

public class MapaTest {
    @Test
    //ENTREGA 0:
    // Una moto atraviesa la grilla sin obstáculos y la cantidad de movimientos es X = 3
    public void unaMotoCruzaLaCiudadYLlegaADestino() {
        Mapa mapa = new Mapa(10, 10);
        Vehiculo unaMoto = new Vehiculo( new Moto(), new Posicion(1, 0));
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
        Vehiculo unAuto = new Vehiculo( new Auto(), new Posicion(1, 0));
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
        Vehiculo camioneta = new Vehiculo( new CuatroPorCuatro(), new Posicion(1, 0));
        mapa.posicionarVehiculo(camioneta);
        mapa.asignarDestinoFinal(new Posicion(1, 3));

        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assert(mapa.verificarFinDeJuego());
    }
}
