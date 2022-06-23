package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoTest {
    @Test
    public void motoReaccionaAPozoAumentandoEnTresLosMovimientos(){
        TipoVehiculo moto = new Moto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        int cantMovimientos = 0;
        assertEquals(moto.reaccionarAPozo(cantMovimientos, mov), 3);
    }

    @Test
    public void motoReaccionaAPiqueteAumentandoEnDosLosMovimientos(){
        TipoVehiculo moto = new Moto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        int cantMovimientos = 0;
        assertEquals(moto.reaccionarAPiquete(cantMovimientos, mov), 2);
    }

    @Test
    public void motoReaccionaASorpresaCambioDeVehiculoYCambiaAAuto(){
        TipoVehiculo moto = new Moto();
        Posicion pos = new Posicion(0,0);
        DireccionDerecha der = DireccionDerecha.getDireccionDerecha();
        Movimiento mov = new Movimiento(pos,der);
        int cantMovimientos = 0;
        assert(moto.cambioVehiculo().getClass().isInstance(new Auto()));
    }
}
