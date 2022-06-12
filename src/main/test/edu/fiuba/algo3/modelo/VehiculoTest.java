package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiculoTest {
    @Test
    //ENTREGA 0: Una moto atraviesa la grilla sin obstáculos y la cantidad de movimientos es X = 3
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
    public void unaMotoCruzaLaCiudaYAlEncuentrarceConUnPozoEsPenalizada() {
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
}
