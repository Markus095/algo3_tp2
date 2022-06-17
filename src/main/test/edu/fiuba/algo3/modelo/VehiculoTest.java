package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.lang.reflect.MalformedParameterizedTypeException;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {
    @Test
    //ENTREGA 0:
    // Una moto atraviesa la grilla sin obstáculos y la cantidad de movimientos es X = 3
    public void unaMotoCruzaLaCiudadYLlegaADestino() {
        Mapa mapa = new Mapa(10, 10);
        Vehiculo unaMoto = new Vehiculo( new Moto(),1, 0);

        mapa.asignarDestinoFinal(1, 3);
        Posicion posicionllegada = mapa.obtenerPosicionLlegada();

        unaMoto.moverDerecha();
        unaMoto.moverDerecha();
        unaMoto.moverDerecha();

        assert(mapa.verificarFinDeJuego(unaMoto, posicionllegada));
    }

    @Test
    //ENTREGA 1:
    //Una moto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en tres movimientos.
    public void unaMotoCruzaLaCiudaYAlEncontrarseConUnPozoEsPenalizada() {
        Mapa mapa = new Mapa(10, 10);
        Vehiculo unaMoto = new Vehiculo(new Moto(), 1, 0);

        Pozo unPozo = new Pozo();
        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(1, 2);

        mapa.posicionarObjeto(unPozo, pos1, pos2);

        //Calle vacia
        // TODO: mapa.moverDerecha(unaMoto)
        if (mapa.verificarCalleDerecha(unaMoto)) {
            unaMoto.moverDerecha();
        }

        //Calle vacia
        if (mapa.verificarCalleDerecha(unaMoto)) {
            unaMoto.moverDerecha();
        }

        //Calle con Pozo
        if (mapa.verificarCalleDerecha(unaMoto)) {
            unaMoto.moverDerecha();
        }

        assertEquals(unaMoto.obtenerCantidadMovimientos(), 6);

    }

    @Test
    //ENTREGA 1:
    //Una Auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en tres movimientos.
    public void unAutoCruzaLaCiudaYAlEncontrarseConUnPozoEsPenalizado() {
        Mapa mapa = new Mapa(10, 10);
        Vehiculo unAuto = new Vehiculo(new Auto(), 1, 0);

        Pozo unPozo = new Pozo();
        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(1, 2);

        mapa.posicionarObjeto(unPozo, pos1, pos2);

        //Calle vacia
        if (mapa.verificarCalleDerecha(unAuto)) {
            unAuto.moverDerecha();
        }

        //Calle vacia
        if (mapa.verificarCalleDerecha(unAuto)) {
            unAuto.moverDerecha();
        }

        //Calle con Pozo
        if (mapa.verificarCalleDerecha(unAuto)) {
            unAuto.moverDerecha();
        }

        assertEquals(unAuto.obtenerCantidadMovimientos(), 6);

    }

    @Test
    //ENTREGA 1:
    //Una 4x4 atraviesa la ciudad y se encuentra con un Pozo. No es penalizada.
    public void unaCuatroPorCuatroCruzaLaCiudaYAlEncontrarseConUnPozoNoEsPenalizada() {
        Mapa mapa = new Mapa(10, 10);
        Vehiculo una4x4 = new Vehiculo(new CuatroPorCuatro(), 1, 0);

        Pozo unPozo = new Pozo();
        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(1, 2);

        mapa.posicionarObjeto(unPozo, pos1, pos2);

        //Calle vacia
        if (mapa.verificarCalleDerecha(una4x4)) {
            una4x4.moverDerecha();
        }

        //Calle vacia
        if (mapa.verificarCalleDerecha(una4x4)) {
            una4x4.moverDerecha();
        }

        //Calle con Pozo
        if (mapa.verificarCalleDerecha(una4x4)) {
            una4x4.moverDerecha();
        }

        assertEquals(una4x4.obtenerCantidadMovimientos(), 3);

    }

    @Test
    //ENTREGA 1:
    //Una 4x4 atraviesa la ciudad y se encuentra con tres pozos, es penalizada.
    public void unCuatroPorCuatroCruzaLaCiudaYAlEncontrarceConTresPozoEsPenalizada() {
        Mapa mapa = new Mapa(10, 10);
        Vehiculo una4x4 = new Vehiculo(new CuatroPorCuatro(), 1, 1);

        Pozo unPozo = new Pozo();
        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(1, 2);

        mapa.posicionarObjeto(unPozo, pos1, pos2);

        Posicion pos3 = new Posicion(1,2);
        Posicion pos4 = new Posicion(1, 3);

        mapa.posicionarObjeto(unPozo, pos3, pos4);

        Posicion pos5 = new Posicion(1,3);
        Posicion pos6 = new Posicion(1, 4);

        mapa.posicionarObjeto(unPozo, pos5, pos6);

        //Calle vacia
        if (mapa.verificarCalleDerecha(una4x4)) {
            una4x4.moverDerecha();
        }

        //Calle vacia
        if (mapa.verificarCalleDerecha(una4x4)) {
            una4x4.moverDerecha();
        }

        //Calle con Pozo
        if (mapa.verificarCalleDerecha(una4x4)) {
            una4x4.moverDerecha();
        }

        assertEquals(una4x4.obtenerCantidadMovimientos(), 5);

    }

    @Test
    //ENTREGA 1:
    //Un Auto atraviesa la ciudad y se encuentra con tres Pozos. Es penalizada con tres movimientos en cada pozo.
    public void unAutoCruzaLaCiudaYAlEncontrarseConVariosPozosEsPenalizadaEnTodosLosEncuentros() {
        Mapa mapa = new Mapa(10, 10);
        Vehiculo unAuto = new Vehiculo(new Auto(), 1, 1);

        Pozo unPozo = new Pozo();
        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(1, 2);

        mapa.posicionarObjeto(unPozo, pos1, pos2);

        Posicion pos3 = new Posicion(1,2);
        Posicion pos4 = new Posicion(1, 3);

        mapa.posicionarObjeto(unPozo, pos3, pos4);

        Posicion pos5 = new Posicion(1,3);
        Posicion pos6 = new Posicion(1, 4);

        mapa.posicionarObjeto(unPozo, pos5, pos6);

        //Calle vacia
        if (mapa.verificarCalleDerecha(unAuto)) {
            unAuto.moverDerecha();
        }

        //Calle vacia
        if (mapa.verificarCalleDerecha(unAuto)) {
            unAuto.moverDerecha();
        }

        //Calle con Pozo
        if (mapa.verificarCalleDerecha(unAuto)) {
            unAuto.moverDerecha();
        }

        assertEquals(unAuto.obtenerCantidadMovimientos(), 12);

    }

    @Test
    //ENTREGA 2:
    //Un vehículo atraviesa la ciudad y encuentra una sorpresa favorable.
    public void UnVehiculoAtraviesaLaCiudadSeEncuentraConSorpresaFavorable() {
        Mapa mapa = new Mapa(14, 14);
        Vehiculo vehiculo = new Vehiculo(new Auto(), 1, 0);

        SorpresaFavorable sorpresa = new SorpresaFavorable();

        Posicion pos1 = new Posicion(6,4);
        Posicion pos2 = new Posicion(7, 4);

        mapa.posicionarObjeto(sorpresa,pos1, pos2);

        for (int i = 0; i < 4; i++) {
            if (mapa.verificarCalleDerecha(vehiculo)) {
                vehiculo.moverDerecha();
            }
        }
        for (int j  = 0; j < 6; j++) {
            if (mapa.verificarCalleAbajo(vehiculo)) {
                vehiculo.moverAbajo();
            }
        }

        assertEquals(vehiculo.obtenerCantidadMovimientos(), 8.200001, 0.01);
    }

    @Test
    //ENTREGA 2:
    //Un vehículo atraviesa la ciudad y encuentra una sorpresa desfavorable.
    public void UnVehiculoAtraviesaLaCiudadSeEncuentraConSorpresaDesfavorable() {
        Mapa mapa = new Mapa(14, 14);
        Vehiculo vehiculo = new Vehiculo(new Auto(), 1, 0);

        SorpresaDesfavorable sorpresa = new SorpresaDesfavorable();

        Posicion pos1 = new Posicion(4,4);
        Posicion pos2 = new Posicion(5, 4);

        mapa.posicionarObjeto(sorpresa, pos1, pos2);

        for (int i = 0; i < 4; i++) {
            if (mapa.verificarCalleDerecha(vehiculo)) {
                vehiculo.moverDerecha();
            }
        }
        for (int j  = 0; j < 4; j++) {
            if (mapa.verificarCalleAbajo(vehiculo)) {
                vehiculo.moverAbajo();
            }
        }

        assertEquals(vehiculo.obtenerCantidadMovimientos(), 9.75, 0.01);
    }

    //Un vehículo atraviesa la ciudad y encuentra una sorpresa cambio de vehículo.
    @Test
    public void unMotoAtraviesaLaCiudadYSeEncuentraConUnaSorpresaCambioDeVehiculo(){
        Mapa mapa = new Mapa(14, 14);
        Vehiculo unVehiculo = new Vehiculo(new Moto(), 9, 9);

        SorpresaCambioVehiculo unaSorpresa = new SorpresaCambioVehiculo();

        Posicion pos1 = new Posicion(6,5);
        Posicion pos2 = new Posicion(5, 5);

        mapa.posicionarObjeto(unaSorpresa, pos1, pos2);

        for (int i = 0; i < 4; i++) {
            if (mapa.verificarCalleIzquierda(unVehiculo)) {
                unVehiculo.moverIzquierda();
            }
        }
        for (int j  = 0; j < 4; j++) {
            if (mapa.verificarCalleArriba(unVehiculo)) {
                unVehiculo.moverArriba();
            }
        }
        assert(unVehiculo.obtenerTipo().getClass().getSimpleName().equals("Auto"));

    }

    @Test
    public void AutoAtraviesaLaCiudadYSeEncuentraUnPiquete() {
        Mapa mapa = new Mapa(14, 14);
        Vehiculo unVehiculo = new Vehiculo(new Auto(), 9, 9);

        Piquete unPiquete = new Piquete();

        Posicion pos1 = new Posicion(6,5);
        Posicion pos2 = new Posicion(5, 5);

        mapa.posicionarObjeto(unPiquete, pos1, pos2);

        for (int i = 0; i < 4; i++) {
            if (mapa.verificarCalleIzquierda(unVehiculo)) {
                unVehiculo.moverIzquierda();
            }
        }
        for (int j  = 0; j < 3; j++) {
            if (mapa.verificarCalleArriba(unVehiculo)) {
                unVehiculo.moverArriba();
            }
        }
        assertFalse(mapa.verificarCalleArriba(unVehiculo));
    }

    @Test
    public void CuatroPorCuatroAtraviesaLaCiudadYSeEncuentraUnPiquete() {
        Mapa mapa = new Mapa(14, 14);
        Vehiculo unVehiculo = new Vehiculo(new CuatroPorCuatro(), 9, 9);

        Piquete unPiquete = new Piquete();

        Posicion pos1 = new Posicion(6,5);
        Posicion pos2 = new Posicion(5, 5);

        mapa.posicionarObjeto(unPiquete, pos1, pos2);

        for (int i = 0; i < 4; i++) {
            if (mapa.verificarCalleIzquierda(unVehiculo)) {
                unVehiculo.moverIzquierda();
            }
        }
        for (int j  = 0; j < 3; j++) {
            if (mapa.verificarCalleArriba(unVehiculo)) {
                unVehiculo.moverArriba();
            }
        }
        assertFalse(mapa.verificarCalleArriba(unVehiculo));
    }

    @Test
    public void MotoAtraviesaLaCiudadYSeEncuentraUnPiquete() {
        Mapa mapa = new Mapa(14, 14);
        Vehiculo unVehiculo = new Vehiculo(new Moto(), 9, 9);

        Piquete unPiquete = new Piquete();

        Posicion pos1 = new Posicion(6,5);
        Posicion pos2 = new Posicion(5, 5);

        mapa.posicionarObjeto(unPiquete, pos1, pos2);

        for (int i = 0; i < 4; i++) {
            if (mapa.verificarCalleIzquierda(unVehiculo)) {
                unVehiculo.moverIzquierda();
            }
        }
        for (int j  = 0; j < 3; j++) {
            if (mapa.verificarCalleArriba(unVehiculo)) {
                unVehiculo.moverArriba();
            }
        }
        assert(mapa.verificarCalleArriba(unVehiculo));
    }
}




