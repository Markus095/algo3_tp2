package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.entidadesCalle.*;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.tablero.Calle;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalleTest {
    @Test
    public void unaCallePorDefectoNoAplicaPenalizacion(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Direccion dir = DireccionDerecha.getDireccionDerecha();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        Calle calle = new Calle(pos1, pos2);
        calle.aplicarPenalizacion(vehiculo,dir, pos1);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 0);
    }

    @Test
    public void unaCalleConUnPozoAplicaPenalizacionDeTresMovimientos(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Direccion dir = DireccionDerecha.getDireccionDerecha();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        Calle calle = new Calle(pos1, pos2);
        calle.guardarObjeto(new Pozo());
        calle.aplicarPenalizacion(vehiculo,dir, pos1);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 3);
    }

    @Test
    public void unaCalleConUnPiqueteNoAplicaPenalizacionDeMovimientosAUnAuto(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Direccion dir = DireccionDerecha.getDireccionDerecha();
        TipoVehiculo auto = new Auto(new Probabilidad(0.5f));
        Vehiculo vehiculo = new Vehiculo(auto, pos1);
        Calle calle = new Calle(pos1, pos2);
        calle.guardarObjeto(new Piquete());
        calle.aplicarPenalizacion(vehiculo,dir, pos1);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 0);
    }

    @Test
    public void unaCalleConUnPiqueteNoAplicaPenalizacionDeMovimientosAUna4x4(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Direccion dir = DireccionDerecha.getDireccionDerecha();
        TipoVehiculo camioneta = new CuatroPorCuatro(new Probabilidad(0.3f));
        Vehiculo vehiculo = new Vehiculo(camioneta, pos1);
        Calle calle = new Calle(pos1, pos2);
        calle.guardarObjeto(new Piquete());
        calle.aplicarPenalizacion(vehiculo,dir, pos1);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 0);
    }

    @Test
    public void unaCalleConUnPiqueteAplicaPenalizacionDeDosMovimientosAUnaMoto(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Direccion dir = DireccionDerecha.getDireccionDerecha();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        Calle calle = new Calle(pos1, pos2);
        calle.guardarObjeto(new Piquete());
        calle.aplicarPenalizacion(vehiculo,dir, pos1);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 2);
    }

    @Test
    public void unaCalleConUnaSorpresaFavorableReduceMovimientosAUnaMoto(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Posicion pos3 = new Posicion(0,2);

        Calle calleVacia = new Calle(pos1, pos2);
        Calle calleSorpresa = new Calle(pos2, pos3);

        Direccion der = DireccionDerecha.getDireccionDerecha();
        Direccion izq = DireccionIzquierda.getDireccionIzquierda();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        ArrayList<Calle> calles  = new ArrayList<>();
        calles.add(calleVacia);
        calles.add(calleSorpresa);

        for(int i = 0; i<4; i++){
            vehiculo.moverseEn(calles, der);
            vehiculo.moverseEn(calles, izq);
        }
        vehiculo.moverseEn(calles, der);

        calleSorpresa.guardarObjeto(new SorpresaFavorable());
        calleSorpresa.aplicarPenalizacion(vehiculo,der, pos2);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 7);
    }


    @Test
    public void unaCalleConUnaSorpresaDesfavorableAumentaMovimientosAUnaMoto(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Posicion pos3 = new Posicion(0,2);

        Calle calleVacia = new Calle(pos1, pos2);
        Calle calleSorpresa = new Calle(pos2, pos3);

        Direccion der = DireccionDerecha.getDireccionDerecha();
        Direccion izq = DireccionIzquierda.getDireccionIzquierda();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        ArrayList<Calle> calles  = new ArrayList<>();
        calles.add(calleVacia);
        calles.add(calleSorpresa);

        for(int i = 0; i<4; i++){
            vehiculo.moverseEn(calles, der);
            vehiculo.moverseEn(calles, izq);
        }
        vehiculo.moverseEn(calles, der);

        calleSorpresa.guardarObjeto(new SorpresaDesfavorable());
        calleSorpresa.aplicarPenalizacion(vehiculo,der, pos2);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 11);
    }

    @Test
    public void unaCalleConUnaSorpresaDesfavorableYUnaFavorableAplicaPenalizacion(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Posicion pos3 = new Posicion(0,2);

        Calle calleVacia = new Calle(pos1, pos2);
        Calle calleSorpresa = new Calle(pos2, pos3);

        Direccion der = DireccionDerecha.getDireccionDerecha();
        Direccion izq = DireccionIzquierda.getDireccionIzquierda();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        ArrayList<Calle> calles  = new ArrayList<>();
        calles.add(calleVacia);
        calles.add(calleSorpresa);

        for(int i = 0; i<4; i++){
            vehiculo.moverseEn(calles, der);
            vehiculo.moverseEn(calles, izq);
        }
        vehiculo.moverseEn(calles, der);

        calleSorpresa.guardarObjeto(new SorpresaDesfavorable());
        calleSorpresa.guardarObjeto(new SorpresaFavorable());
        calleSorpresa.aplicarPenalizacion(vehiculo,der, pos2);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 9);
    }

    @Test
    public void unaCalleConUnaSorpresaDesfavorableYUnPozoAplicaPenalizacion(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Posicion pos3 = new Posicion(0,2);

        Calle calleVacia = new Calle(pos1, pos2);
        Calle calleSorpresa = new Calle(pos2, pos3);

        Direccion der = DireccionDerecha.getDireccionDerecha();
        Direccion izq = DireccionIzquierda.getDireccionIzquierda();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        ArrayList<Calle> calles  = new ArrayList<>();
        calles.add(calleVacia);
        calles.add(calleSorpresa);

        for(int i = 0; i<4; i++){
            vehiculo.moverseEn(calles, der);
            vehiculo.moverseEn(calles, izq);
        }
        vehiculo.moverseEn(calles, der);

        calleSorpresa.guardarObjeto(new SorpresaDesfavorable());
        calleSorpresa.guardarObjeto(new Pozo());
        calleSorpresa.aplicarPenalizacion(vehiculo,der, pos2);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 14);
    }

    @Test
    public void unaCalleConUnaSorpresaFavorableYUnPozoAplicaPenalizacion(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Posicion pos3 = new Posicion(0,2);

        Calle calleVacia = new Calle(pos1, pos2);
        Calle calleSorpresa = new Calle(pos2, pos3);

        Direccion der = DireccionDerecha.getDireccionDerecha();
        Direccion izq = DireccionIzquierda.getDireccionIzquierda();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        ArrayList<Calle> calles  = new ArrayList<>();
        calles.add(calleVacia);
        calles.add(calleSorpresa);

        for(int i = 0; i<4; i++){
            vehiculo.moverseEn(calles, der);
            vehiculo.moverseEn(calles, izq);
        }
        vehiculo.moverseEn(calles, der);

        calleSorpresa.guardarObjeto(new SorpresaFavorable());
        calleSorpresa.guardarObjeto(new Pozo());
        calleSorpresa.aplicarPenalizacion(vehiculo,der, pos2);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 10);
    }

    @Test
    public void unaCalleConTresPozosAplicaPenalizacion(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Posicion pos3 = new Posicion(0,2);

        Calle calleVacia = new Calle(pos1, pos2);
        Calle calleSorpresa = new Calle(pos2, pos3);

        Direccion der = DireccionDerecha.getDireccionDerecha();
        Direccion izq = DireccionIzquierda.getDireccionIzquierda();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        ArrayList<Calle> calles  = new ArrayList<>();
        calles.add(calleVacia);
        calles.add(calleSorpresa);

        for(int i = 0; i<4; i++){
            vehiculo.moverseEn(calles, der);
            vehiculo.moverseEn(calles, izq);
        }
        vehiculo.moverseEn(calles, der);

        calleSorpresa.guardarObjeto(new Pozo());
        calleSorpresa.guardarObjeto(new Pozo());
        calleSorpresa.guardarObjeto(new Pozo());
        calleSorpresa.aplicarPenalizacion(vehiculo,der, pos2);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 18);
    }
}
