package edu.fiuba.algo3.modelo;

import java.util.List;

/* public class Mapa {
    Posicion [][] mapa = new Posicion[10][10];
    private Posicion posDestino;

    public Mapa(Posicion posicionDestino){
        for(int i=0;i<10;i++){
            for(int j = 0; 10 > j; j++){
                mapa[i][j] = new Posicion(i,j);
            }
        }
        Destino destino = new Destino();
        posicionDestino.colocar(destino);
        this.posDestino= posicionDestino;
    }
    public void posicionar(Contenido contenido, Posicion posicion) {
        Posicion posicionAColocar = mapa[posicion.getFila()][posicion.getColumna()];
        posicionAColocar.colocar(contenido);
    }

    public Posicion mover(Moto moto, Posicion unaPosicion, Direccion unaDireccion) {
        Posicion nuevaPosicion = unaPosicion.obtenerAdyacente(unaDireccion);
        nuevaPosicion.reaccionarA(moto);
        posicionar(moto, nuevaPosicion);
        return nuevaPosicion;
    }

    public boolean gano() {
        return this.posDestino.getContenido().gano();
    }
} */

public class Mapa {
    private int dimension;
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
    public void mover(Moto unaMoto, char unaDireccion) {
        Posicion posicionMoto = unaMoto.obtenerPosicion();
        int posicionMotoFila = posicionMoto.obtenerFila();
        int posicionMotoColumna = posicionMoto.obtenerColumna();

        if (unaDireccion == 'D') {
            Posicion nuevaPosicion = obtenerPosicion(posicionMotoFila, posicionMotoColumna + 2);
        }else if (unaDireccion == 'W') {
            Posicion nuevaPosicion = obtenerPosicion(posicionMotoFila + 2, posicionMotoColumna);
        }else if (unaDireccion == 'A') {
            Posicion nuevaPosicion = obtenerPosicion(posicionMotoFila, posicionMotoColumna - 2);
        }else {
            Posicion nuevaPosicion = obtenerPosicion(posicionMotoFila - 2, posicionMotoColumna);
        }
    }

    public Posicion obtenerPosicion(int unaFila, int unaColumna) {
        return this.mapa[unaFila][unaColumna];
    }
}