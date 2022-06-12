package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.lang.reflect.MalformedParameterizedTypeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiculoTest {
    @Test
    //ENTREGA 0:
    // Una moto atraviesa la grilla sin obstáculos y la cantidad de movimientos es X = 3
    public void unaMotoCruzaLaCiudadYLlegaADestino() {
        Mapa mapa = new Mapa(10, 10);
        Moto unaMoto = new Moto(1, 1);

        mapa.asignarDestinoFinal(1, 7);
        Posicion posicionllegada = mapa.obtenerPosicionLlegada();

        unaMoto.moverDerecha();
        unaMoto.moverDerecha();
        unaMoto.moverDerecha();

        assertEquals(mapa.verificarFinDeJuego(unaMoto, posicionllegada), true);
    }

    @Test
    //ENTREGA 1:
    //Una moto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en tres movimientos.
    public void unaMotoCruzaLaCiudaYAlEncontrarceConUnPozoEsPenalizada() {
        Mapa mapa = new Mapa(10, 10);
        Moto unaMoto = new Moto(1, 1);

        Pozo unPozo = new Pozo();
        mapa.posicionarObjeto(unPozo, 1, 6);

        //Calle vacia
        mapa.verificarCalleDerecha(unaMoto);
        unaMoto.moverDerecha();

        //Calle vacia
        mapa.verificarCalleDerecha(unaMoto);
        unaMoto.moverDerecha();

        //Calle con Pozo
        mapa.verificarCalleDerecha(unaMoto);
        unaMoto.moverDerecha();

        assertEquals(unaMoto.obtenerCantidadMovimientos(), 6);

    }

    @Test
    //ENTREGA 1:
    //Una Auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en tres movimientos.
    public void unAutoCruzaLaCiudaYAlEncontrarceConUnPozoEsPenalizada() {
        Mapa mapa = new Mapa(10, 10);
        Auto unAuto = new Auto(1, 1);

        Pozo unPozo = new Pozo();
        mapa.posicionarObjeto(unPozo, 1, 6);

        //Calle vacia
        mapa.verificarCalleDerecha(unAuto);
        unAuto.moverDerecha();

        //Calle vacia
        mapa.verificarCalleDerecha(unAuto);
        unAuto.moverDerecha();

        //Calle con Pozo
        mapa.verificarCalleDerecha(unAuto);
        unAuto.moverDerecha();

        assertEquals(unAuto.obtenerCantidadMovimientos(), 6);

    }

    @Test
    //ENTREGA 1:
    //Una 4x4 atraviesa la ciudad y se encuentra con un Pozo. No es penalizada.
    public void unCuatroPorCuatroCruzaLaCiudaYAlEncontrarceConUnPozoNoEsPenalizada() {
        Mapa mapa = new Mapa(10, 10);
        CuatroPorCuatro una4x4 = new CuatroPorCuatro(1, 1);

        Pozo unPozo = new Pozo();
        mapa.posicionarObjeto(unPozo, 1, 6);

        //Calle vacia
        mapa.verificarCalleDerecha(una4x4);
        una4x4.moverDerecha();

        //Calle vacia
        mapa.verificarCalleDerecha(una4x4);
        una4x4.moverDerecha();

        //Calle con Pozo
        mapa.verificarCalleDerecha(una4x4);
        una4x4.moverDerecha();

        assertEquals(una4x4.obtenerCantidadMovimientos(), 3);

    }

    @Test
    //ENTREGA 1:
    //Una 4x4 atraviesa la ciudad y se encuentra con tres pozos, es penalizada.
    public void unCuatroPorCuatroCruzaLaCiudaYAlEncontrarceConTresPozoEsPenalizada() {
        Mapa mapa = new Mapa(10, 10);
        CuatroPorCuatro una4x4 = new CuatroPorCuatro(1, 1);

        Pozo primerPozo = new Pozo();
        mapa.posicionarObjeto(primerPozo, 1, 2);

        Pozo segundoPozo = new Pozo();
        mapa.posicionarObjeto(segundoPozo, 1, 4);

        Pozo tercerPozo = new Pozo();
        mapa.posicionarObjeto(tercerPozo, 1, 6);

        //Calle vacia
        mapa.verificarCalleDerecha(una4x4);
        una4x4.moverDerecha();

        //Calle vacia
        mapa.verificarCalleDerecha(una4x4);
        una4x4.moverDerecha();

        //Calle con Pozo
        mapa.verificarCalleDerecha(una4x4);
        una4x4.moverDerecha();

        assertEquals(una4x4.obtenerCantidadMovimientos(), 5);

    }

    @Test
    //ENTREGA 1:
    //Un Auto atraviesa la ciudad y se encuentra con tres Pozos. Es penalizada con tres movimientos en cada pozo.
    public void unAutoCruzaLaCiudaYAlEncontrarceConVariosPozosEsPenalizadaEnTodosEncuentros() {
        Mapa mapa = new Mapa(10, 10);
        Auto unAuto = new Auto(1, 1);

        Pozo primerPozo = new Pozo();
        mapa.posicionarObjeto(primerPozo, 1, 2);

        Pozo segundoPozo = new Pozo();
        mapa.posicionarObjeto(segundoPozo, 1, 4);

        Pozo tercerPozo = new Pozo();
        mapa.posicionarObjeto(tercerPozo, 1, 6);

        //Calle vacia
        mapa.verificarCalleDerecha(unAuto);
        unAuto.moverDerecha();

        //Calle vacia
        mapa.verificarCalleDerecha(unAuto);
        unAuto.moverDerecha();

        //Calle con Pozo
        mapa.verificarCalleDerecha(unAuto);
        unAuto.moverDerecha();

        assertEquals(unAuto.obtenerCantidadMovimientos(), 12);

    }

    @Test
    //ENTREGA 2:
    //Un vehículo atraviesa la ciudad y encuentra una sorpresa favorable.
    public void UnVehiculoAtraviesaLaCiudadSeEncuentraConSorpresa() {
        Mapa mapa = new Mapa(14, 14);
        Auto vehiculo = new Auto(1, 1);
        SorpresaFavorable sorpresa = new SorpresaFavorable(); //12, 9
        mapa.posicionarObjeto(sorpresa, 12, 9);

        for (int i = 0; i < 4; i++) {
            mapa.verificarCalleDerecha(vehiculo);
            vehiculo.moverDerecha();
        }
        for (int i  = 0; i < 6; i++) {
            mapa.verificarCalleAbajo(vehiculo);
            vehiculo.moverAbajo();
        }

        assertEquals(vehiculo.obtenerCantidadMovimientos(), 8);
    }
}



