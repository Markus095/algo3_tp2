package edu.fiuba.algo3.modelo;

import java.util.List;


public class Mapa {
    private int dimension;
    private Posicion posicionDestino;
    private Posicion[][] mapa;

    public Mapa(int unaDimension) {
        this.dimension = unaDimension;
        this.mapa = new Posicion[this.dimension][this.dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    mapa[i][j] = new Manzana(i, j);
                } else if (i % 2 == 1 && j % 2 == 1) {
                    mapa[i][j] = new Esquina(i, j);
                } else {
                    mapa[i][j] = new Calle(i, j);
                }
            }
        }
    }
    public boolean moverVehiculoEnDireccion(Moto unaMoto, char unaDireccion) {
        Posicion nuevaPosicion;
        Posicion posicionMoto = unaMoto.obtenerPosicion();
        int posicionMotoFila = posicionMoto.obtenerFila();
        int posicionMotoColumna = posicionMoto.obtenerColumna();
        boolean estadoMovimiento = false;

        if (unaDireccion == 'D') {
            nuevaPosicion = obtenerPosicion(posicionMotoFila, posicionMotoColumna + 2);
        }else if (unaDireccion == 'W') {
            nuevaPosicion = obtenerPosicion(posicionMotoFila + 2, posicionMotoColumna);
        }else if (unaDireccion == 'A') {
            nuevaPosicion = obtenerPosicion(posicionMotoFila, posicionMotoColumna - 2);
        }else {
            nuevaPosicion = obtenerPosicion(posicionMotoFila - 2, posicionMotoColumna);
        }
        unaMoto.moverA(nuevaPosicion);
        estadoMovimiento = unaMoto.obtenerPosicion().equals(this.posicionDestino);
        return estadoMovimiento;
    }
    public int asignarPosicionDestino(int unaFila, int unaColumna) {
        this.posicionDestino = obtenerPosicion(unaFila, unaColumna);
        return 0;
    }

    public Posicion obtenerPosicion(int unaFila, int unaColumna) {
        return this.mapa[unaFila][unaColumna];
    }
}