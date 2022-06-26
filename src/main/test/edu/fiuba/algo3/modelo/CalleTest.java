package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

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
        Direccion dir = DireccionDerecha.getDireccionDerecha();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        vehiculo.setMovimientos(10);
        Calle calle = new Calle(pos1, pos2);
        calle.guardarObjeto(new SorpresaFavorable());
        calle.aplicarPenalizacion(vehiculo,dir, pos1);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 8);
    }


    @Test
    public void unaCalleConUnaSorpresaDesfavorableAumentaMovimientosAUnaMoto(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Direccion dir = DireccionDerecha.getDireccionDerecha();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        vehiculo.setMovimientos(10);
        Calle calle = new Calle(pos1, pos2);
        calle.guardarObjeto(new SorpresaDesfavorable());
        calle.aplicarPenalizacion(vehiculo,dir, pos1);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 13);
    }

    @Test
    public void unaCalleConUnaSorpresaDesfavorableYUnaFavorableAplicaPenalizacion(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Direccion dir = DireccionDerecha.getDireccionDerecha();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        vehiculo.setMovimientos(10);
        Calle calle = new Calle(pos1, pos2);
        calle.guardarObjeto(new SorpresaFavorable());
        calle.guardarObjeto(new SorpresaDesfavorable());
        calle.aplicarPenalizacion(vehiculo,dir, pos1);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 10);
    }

    @Test
    public void unaCalleConUnaSorpresaDesfavorableYUnPozoAplicaPenalizacion(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Direccion dir = DireccionDerecha.getDireccionDerecha();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        vehiculo.setMovimientos(10);
        Calle calle = new Calle(pos1, pos2);
        calle.guardarObjeto(new Pozo());
        calle.guardarObjeto(new SorpresaDesfavorable());
        calle.aplicarPenalizacion(vehiculo,dir, pos1);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 16);
    }

    @Test
    public void unaCalleConUnaSorpresaFavorableYUnPozoAplicaPenalizacion(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Direccion dir = DireccionDerecha.getDireccionDerecha();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        vehiculo.setMovimientos(10);
        Calle calle = new Calle(pos1, pos2);
        calle.guardarObjeto(new Pozo());
        calle.guardarObjeto(new SorpresaFavorable());
        calle.aplicarPenalizacion(vehiculo,dir, pos1);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 10);
    }


    @Test
    public void unaCalleConTresPozosAplicaPenalizacion(){
        Posicion pos1 = new Posicion(0,0);
        Posicion pos2 = new Posicion(0,1);
        Direccion dir = DireccionDerecha.getDireccionDerecha();
        TipoVehiculo moto = new Moto(new Probabilidad(0.8f));
        Vehiculo vehiculo = new Vehiculo(moto, pos1);
        vehiculo.setMovimientos(10);
        Calle calle = new Calle(pos1, pos2);
        calle.guardarObjeto(new Pozo());
        calle.guardarObjeto(new Pozo());
        calle.guardarObjeto(new Pozo());
        calle.aplicarPenalizacion(vehiculo,dir, pos1);
        assertEquals(vehiculo.obtenerCantidadMovimientos(), 19);
    }





}
