package edu.fiuba.algo3.modelo;

import java.util.Arrays;
import java.util.List;

/* public class Posicion {
    private int fila;
    private int columna;
    private Contenido contenido;

    public Posicion(int unaFila, int unaColumna){
        this.fila = unaFila;
        this.columna = unaColumna;
    }


    public int getFila() {
        return this.fila;
    }

    public int getColumna() {
        return this.columna;
    }

    public void colocar(Contenido contenido) {
        this.contenido = contenido;
    }

    public Posicion obtenerAdyacente(Direccion unaDireccion) {
        int unaFila = this.fila;
        int unaColumna = this.columna;
        if(unaDireccion.getDireccion() == 'D'){
            unaColumna ++;
        }
        else if(unaDireccion.getDireccion() == 'S'){
            unaFila++;
        }
        List<Integer> coordenadas = Arrays.asList(unaFila,unaColumna);
        return (Posicion) coordenadas;
    }

    public void reaccionarA(Moto moto) {
        this.contenido.reaccionarA(moto);
    }

    public Contenido getContenido() {
        return this.contenido;
    }
}
 */

public abstract class Posicion {
    private int fila;
    private int columna;
    public Posicion(int unaFila, int unaColumna) {
        this.fila = unaFila;
        this.columna = unaColumna;
    }

}