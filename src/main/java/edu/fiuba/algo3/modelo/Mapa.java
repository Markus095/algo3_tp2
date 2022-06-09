package edu.fiuba.algo3.modelo;

import java.util.List;

public class Mapa {
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
}
