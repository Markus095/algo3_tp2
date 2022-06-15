package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Mapa {
    private int fila;
    private  int columna;
    private Posicion posicionDestino;
    private Posicion [][] mapa;
    private ArrayList<Calle> calles = new ArrayList<>();

    public Mapa(int unaFila, int unaColumna) {
        this.fila = unaFila;
        this.columna = unaColumna;
        this.mapa = new Posicion[unaFila][unaColumna];
        for (int i = 0; i < unaFila; i ++) {
            for (int j = 0; j < unaColumna; j++) {
                this.mapa[i][j] = new Posicion(i, j);
                if(j != 0){ calles.add( new Calle(this.mapa[i][j-1], this.mapa[i][j])); }
                if(i != 0){ calles.add( new Calle(this.mapa[i-1][j], this.mapa[i][j])); }
            }
        }
    }

    public int asignarDestinoFinal(int unaFila, int unaColumna) {
        this.posicionDestino = obtenerPosicion(unaFila, unaColumna);
        return 0;
    }

    public Posicion obtenerPosicion(int unaFila, int unaColumna) {
        return this.mapa[unaFila][unaColumna];
    }

    public Posicion obtenerPosicionLlegada() {
        return this.posicionDestino;
    }


    public boolean verificarFinDeJuego(Moto unaMoto, Posicion posicionLlegada) {
        return(unaMoto.obtenerPosicionMoto().obtenerFila() == posicionLlegada.obtenerFila() && unaMoto.obtenerPosicionMoto().obtenerColumna() == posicionLlegada.obtenerColumna());
    }

    public void posicionarObjeto(Objeto unObjeto, Posicion pos1, Posicion pos2) {
        Calle calle = buscarCalle(pos1, pos2);
        calle.guardarObjeto(unObjeto);
    }

    private Calle buscarCalle(Posicion pos1, Posicion pos2) {
        // este metodo se puede implementar bien con streams
        for (Calle calle : calles) {
            if (calle.vaDesdeHasta(pos1, pos2) || calle.vaDesdeHasta(pos2,pos1)) return calle;
        }
        return new Calle(pos1,pos2);//a corregir
    }

    public void verificarCalleDerecha(Vehiculo unVehiculo) {
        Posicion posicionVehiculo = unVehiculo.obtenerPosicionMoto();
        Posicion posicionDestino = this.mapa[posicionVehiculo.obtenerFila()][posicionVehiculo.obtenerColumna()+1];
        buscarCalle(posicionVehiculo, posicionDestino).aplicarPenalizacion(unVehiculo);
    }

    public void verificarCalleAbajo(Auto unVehiculo) {
        Posicion posicionVehiculo = unVehiculo.obtenerPosicionMoto();
        Posicion posicionDestino = this.mapa[posicionVehiculo.obtenerFila()+1][posicionVehiculo.obtenerColumna()];
        buscarCalle(posicionVehiculo, posicionDestino).aplicarPenalizacion(unVehiculo);
    }

}
