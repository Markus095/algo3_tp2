package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.entidadesCalle.*;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {

    @Test
    //ENTREGA 1:
    //Una moto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en tres movimientos.
    public void unaMotoCruzaLaCiudaYAlEncontrarseConUnPozoEsPenalizada() {
        Mapa mapa = new Mapa(10, 10);
        TipoVehiculo tipoMoto = new Moto(new Probabilidad(0.8f));
        Vehiculo unaMoto = new Vehiculo(tipoMoto, new Posicion(1, 0));
        mapa.posicionarVehiculo(unaMoto);

        Posicion posicionDestino = new Posicion(10, 10);
        mapa.asignarDestinoFinal(posicionDestino);

        Pozo unPozo = new Pozo();
        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(1, 2);

        mapa.posicionarObjeto(unPozo, pos1, pos2);
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assertEquals(unaMoto.obtenerCantidadMovimientos(), 6);

    }

    @Test
    //ENTREGA 1:
    //Una Auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en tres movimientos.
    public void unAutoCruzaLaCiudaYAlEncontrarseConUnPozoEsPenalizado() {
        Mapa mapa = new Mapa(10, 10);
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        Vehiculo unAuto = new Vehiculo(tipoVehiculo, new Posicion(1, 0));
        mapa.posicionarVehiculo(unAuto);

        Posicion posicionDestino = new Posicion(10, 10);
        mapa.asignarDestinoFinal(posicionDestino);

        Pozo unPozo = new Pozo();
        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(1, 2);

        mapa.posicionarObjeto(unPozo, pos1, pos2);

        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assertEquals(unAuto.obtenerCantidadMovimientos(), 6);

    }

    @Test
    //ENTREGA 1:
    //Una 4x4 atraviesa la ciudad y se encuentra con un Pozo. No es penalizada.
    public void unaCuatroPorCuatroCruzaLaCiudaYAlEncontrarseConUnPozoNoEsPenalizada() {
        Mapa mapa = new Mapa(10, 10);
        TipoVehiculo tipoVehiculo = new CuatroPorCuatro(new Probabilidad(0.3f));
        Vehiculo una4x4 = new Vehiculo(tipoVehiculo, new Posicion(1, 0));
        mapa.posicionarVehiculo(una4x4);

        Posicion posicionDestino = new Posicion(10, 10);
        mapa.asignarDestinoFinal(posicionDestino);

        Pozo unPozo = new Pozo();
        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(1, 2);

        mapa.posicionarObjeto(unPozo, pos1, pos2);

        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assertEquals(una4x4.obtenerCantidadMovimientos(), 3);

    }

    @Test
    //ENTREGA 1:
    //Una 4x4 atraviesa la ciudad y se encuentra con tres pozos, es penalizada.
    public void unCuatroPorCuatroCruzaLaCiudaYAlEncontrarceConTresPozoEsPenalizada() {
        Mapa mapa = new Mapa(10, 10);
        TipoVehiculo tipoVehiculo = new CuatroPorCuatro(new Probabilidad(0.3f));
        Vehiculo una4x4 = new Vehiculo(tipoVehiculo, new Posicion(1, 1));
        mapa.posicionarVehiculo(una4x4);

        Posicion posicionDestino = new Posicion(10, 10);
        mapa.asignarDestinoFinal(posicionDestino);

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

        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assertEquals(una4x4.obtenerCantidadMovimientos(), 5);

    }

    @Test
    //ENTREGA 1:
    //Un Auto atraviesa la ciudad y se encuentra con tres Pozos. Es penalizada con tres movimientos en cada pozo.
    public void unAutoCruzaLaCiudaYAlEncontrarseConVariosPozosEsPenalizadaEnTodosLosEncuentros() {
        Mapa mapa = new Mapa(10, 10);
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        Vehiculo unAuto = new Vehiculo(tipoVehiculo, new Posicion(1, 1));
        mapa.posicionarVehiculo(unAuto);

        Posicion posicionDestino = new Posicion(10, 10);
        mapa.asignarDestinoFinal(posicionDestino);

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

        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assertEquals(unAuto.obtenerCantidadMovimientos(), 12);

    }

    @Test
    //ENTREGA 2:
    //Un vehículo atraviesa la ciudad y encuentra una sorpresa favorable.
    public void UnVehiculoAtraviesaLaCiudadSeEncuentraConSorpresaFavorable() {
        Mapa mapa = new Mapa(14, 14);
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        Vehiculo vehiculo = new Vehiculo(tipoVehiculo, new Posicion(1, 0));
        mapa.posicionarVehiculo(vehiculo);

        Posicion posicionDestino = new Posicion(10, 10);
        mapa.asignarDestinoFinal(posicionDestino);

        SorpresaFavorable sorpresa = new SorpresaFavorable();

        Posicion pos1 = new Posicion(5,4);
        Posicion pos2 = new Posicion(6, 4);

        mapa.posicionarObjeto(sorpresa,pos1, pos2);

        for (int i = 0; i < 4; i++) {
            mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        }
        for (int j  = 0; j < 6; j++) {
            mapa.moverVehiculoEn(DireccionAbajo.getDireccionAbajo());
        }

        assertEquals(vehiculo.obtenerCantidadMovimientos(), 8);
    }

    @Test
    //ENTREGA 2:
    //Un vehículo atraviesa la ciudad y encuentra una sorpresa desfavorable.
    public void UnVehiculoAtraviesaLaCiudadSeEncuentraConSorpresaDesfavorable() {
        Mapa mapa = new Mapa(14, 14);
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        Vehiculo vehiculo = new Vehiculo(tipoVehiculo, new Posicion(1, 0));
        mapa.posicionarVehiculo(vehiculo);

        Posicion posicionDestino = new Posicion(10, 10);
        mapa.asignarDestinoFinal(posicionDestino);

        SorpresaDesfavorable sorpresa = new SorpresaDesfavorable();

        Posicion pos1 = new Posicion(4,4);
        Posicion pos2 = new Posicion(5, 4);

        mapa.posicionarObjeto(sorpresa, pos1, pos2);

        for (int i = 0; i < 4; i++) {
            mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        }
        for (int j  = 0; j < 4; j++) {
            mapa.moverVehiculoEn(DireccionAbajo.getDireccionAbajo());
        }

        assertEquals(vehiculo.obtenerCantidadMovimientos(), 10);
    }


    //Un vehículo atraviesa la ciudad y encuentra una sorpresa cambio de vehículo.
    @Test
    public void unMotoAtraviesaLaCiudadYSeEncuentraConUnaSorpresaCambioDeVehiculo(){
        Mapa mapa = new Mapa(14, 14);
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        Vehiculo unVehiculo = new Vehiculo(tipoVehiculo, new Posicion(9, 9));
        mapa.posicionarVehiculo(unVehiculo);

        Posicion posicionDestino = new Posicion(10, 10);
        mapa.asignarDestinoFinal(posicionDestino);

        SorpresaCambioVehiculo unaSorpresa = new SorpresaCambioVehiculo();

        Posicion pos1 = new Posicion(6,5);
        Posicion pos2 = new Posicion(5, 5);

        mapa.posicionarObjeto(unaSorpresa, pos1, pos2);

        for (int i = 0; i < 4; i++) {
            mapa.moverVehiculoEn(DireccionIzquierda.getDireccionIzquierda());
        }
        for (int j  = 0; j < 4; j++) {
            mapa.moverVehiculoEn(DireccionArriba.getDireccionArriba());
        }

        assert(unVehiculo.obtenerTipo().getClass().getSimpleName().equals("Auto"));

    }

    @Test
    public void AutoAtraviesaLaCiudadYSeEncuentraUnPiquete() {
        Mapa mapa = new Mapa(14, 14);
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        Vehiculo unVehiculo = new Vehiculo(tipoVehiculo, new Posicion(0, 0));
        mapa.posicionarVehiculo(unVehiculo);

        Posicion posicionDestino = new Posicion(10, 10);
        mapa.asignarDestinoFinal(posicionDestino);

        Piquete unPiquete = new Piquete();

        Posicion pos1 = new Posicion(0,2);
        Posicion pos2 = new Posicion(0, 3);

        mapa.posicionarObjeto(unPiquete, pos1, pos2);

        for (int i = 0; i < 2; i++) {
            mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        }

        Posicion ultimaPosicion = new Posicion(unVehiculo.obtenerPosicion().obtenerFila(), unVehiculo.obtenerPosicion().obtenerColumna());


        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assert(unVehiculo.obtenerPosicion().esIgual(ultimaPosicion));
    }

    @Test
    public void CuatroPorCuatroAtraviesaLaCiudadYSeEncuentraUnPiquete() {
        Mapa mapa = new Mapa(14, 14);
        TipoVehiculo tipoVehiculo = new CuatroPorCuatro(new Probabilidad(0.3f));
        Vehiculo unVehiculo = new Vehiculo(tipoVehiculo, new Posicion(0, 0));
        mapa.posicionarVehiculo(unVehiculo);

        Posicion posicionDestino = new Posicion(10, 10);
        mapa.asignarDestinoFinal(posicionDestino);

        Piquete unPiquete = new Piquete();

        Posicion pos1 = new Posicion(0,2);
        Posicion pos2 = new Posicion(0, 3);

        mapa.posicionarObjeto(unPiquete, pos1, pos2);

        for (int i = 0; i < 2; i++) {
            mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        }

        Posicion ultimaPosicion = new Posicion(unVehiculo.obtenerPosicion().obtenerFila(), unVehiculo.obtenerPosicion().obtenerColumna());


        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assert(unVehiculo.obtenerPosicion().esIgual(ultimaPosicion));
    }
    @Test
    public void MotoAtraviesaLaCiudadYSeEncuentraUnPiquete() {
        Mapa mapa = new Mapa(14, 14);
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        Vehiculo unVehiculo = new Vehiculo(tipoVehiculo, new Posicion(0, 0));
        mapa.posicionarVehiculo(unVehiculo);

        Posicion posicionDestino = new Posicion(10, 10);
        mapa.asignarDestinoFinal(posicionDestino);

        Piquete unPiquete = new Piquete();

        Posicion pos1 = new Posicion(0, 2);
        Posicion pos2 = new Posicion(0, 3);

        mapa.posicionarObjeto(unPiquete, pos1, pos2);

        for (int i = 0; i < 2; i++) {
            mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        }

        Posicion ultimaPosicion = new Posicion(unVehiculo.obtenerPosicion().obtenerFila(), unVehiculo.obtenerPosicion().obtenerColumna());


        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assert (!unVehiculo.obtenerPosicion().esIgual(ultimaPosicion) && unVehiculo.obtenerCantidadMovimientos() == 7);
    }

    @Test
    public void MotoAtraviesaLaCiudadYSeEncuentraUnControlPolicial() {
        Mapa mapa = new Mapa(14, 14);
        TipoVehiculo tipoVehiculo = new Moto(new Probabilidad(0.8f));
        Vehiculo unVehiculo = new Vehiculo(tipoVehiculo, new Posicion(0, 0));
        mapa.posicionarVehiculo(unVehiculo);

        Posicion posicionDestino = new Posicion(10, 10);
        mapa.asignarDestinoFinal(posicionDestino);

        ControlPolicial unControl = new ControlPolicial();

        Posicion pos1 = new Posicion(0, 2);
        Posicion pos2 = new Posicion(0, 3);

        mapa.posicionarObjeto(unControl, pos1, pos2);

        for (int i = 0; i < 2; i++) {
            mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        }

        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assert (unVehiculo.obtenerCantidadMovimientos() == 5 || unVehiculo.obtenerCantidadMovimientos() == 8);
    }

    @Test
    public void AutoAtraviesaLaCiudadYSeEncuentraUnControlPolicial() {
        Mapa mapa = new Mapa(14, 14);
        TipoVehiculo tipoVehiculo = new Auto(new Probabilidad(0.5f));
        Vehiculo unVehiculo = new Vehiculo(tipoVehiculo, new Posicion(0, 0));
        mapa.posicionarVehiculo(unVehiculo);

        Posicion posicionDestino = new Posicion(10, 10);
        mapa.asignarDestinoFinal(posicionDestino);

        ControlPolicial unControl = new ControlPolicial();

        Posicion pos1 = new Posicion(0, 2);
        Posicion pos2 = new Posicion(0, 3);

        mapa.posicionarObjeto(unControl, pos1, pos2);

        for (int i = 0; i < 2; i++) {
            mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        }

        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assert (unVehiculo.obtenerCantidadMovimientos() == 5 || unVehiculo.obtenerCantidadMovimientos() == 8);
    }

    @Test
    public void CuatroPorCuatroAtraviesaLaCiudadYSeEncuentraUnControlPolicial() {
        Mapa mapa = new Mapa(14, 14);
        TipoVehiculo tipoVehiculo = new CuatroPorCuatro(new Probabilidad(0.3f));
        Vehiculo unVehiculo = new Vehiculo(tipoVehiculo, new Posicion(0, 0));
        mapa.posicionarVehiculo(unVehiculo);

        Posicion posicionDestino = new Posicion(10, 10);
        mapa.asignarDestinoFinal(posicionDestino);

        ControlPolicial unControl = new ControlPolicial();

        Posicion pos1 = new Posicion(0, 2);
        Posicion pos2 = new Posicion(0, 3);

        mapa.posicionarObjeto(unControl, pos1, pos2);

        for (int i = 0; i < 2; i++) {
            mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        }

        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());

        assert (unVehiculo.obtenerCantidadMovimientos() == 5 || unVehiculo.obtenerCantidadMovimientos() == 8);
    }


}




