package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Mapa {
    private int cantidadFilas;
    private  int cantidadColumnas;
    private boolean seMovio;

    private  Vehiculo vehiculo;
    private Posicion posicionDestino;
    private Posicion [][] mapa;
    private ArrayList<Calle> calles = new ArrayList<>();

    public Mapa(int unaCantidadFilas, int unaCantidadColumnas) {
        this.cantidadFilas = unaCantidadFilas;
        this.cantidadColumnas = unaCantidadColumnas;
        this.mapa = new Posicion[unaCantidadFilas][unaCantidadColumnas];
        for (int i = 0; i < unaCantidadFilas; i ++) {
            for (int j = 0; j < unaCantidadColumnas; j++) {
                this.mapa[i][j] = new Posicion(i, j);
                if(j != 0){ calles.add( new Calle(this.mapa[i][j-1], this.mapa[i][j])); }
                if(i != 0){ calles.add( new Calle(this.mapa[i-1][j], this.mapa[i][j])); }
            }
        }
    }

    public void posicionarVehiculo(Vehiculo unVehiculo) {
        this.vehiculo = unVehiculo;
    }


    public int asignarDestinoFinal(Posicion unaPosicion) {
        this.posicionDestino = unaPosicion;
        return 0;
    }

    public Posicion obtenerPosicion(int unaFila, int unaColumna) {
        return this.mapa[unaFila][unaColumna];
    }

    public Posicion obtenerPosicionLlegada() {
        return this.posicionDestino;
    }


    public boolean verificarFinDeJuego() {
        return(this.vehiculo.obtenerPosicion().esIgual(this.posicionDestino));
    }

    public void posicionarObjeto(Objeto unObjeto, Posicion pos1, Posicion pos2) {
        Calle calle = buscarCalle(pos1, pos2);
        calle.guardarObjeto(unObjeto);
    }
//quizas hay que hacer un objeto calles?
    private Calle buscarCalle(Posicion pos1, Posicion pos2) {
        // este metodo se puede implementar bien con streams
        for (Calle calle : calles) {
            if (calle.vaDesdeHasta(pos1, pos2) || calle.vaDesdeHasta(pos2,pos1)) return calle;
        }
        return new Calle(pos1,pos2);//a corregir
    }


    public void moverDerecha() {
        boolean estado = buscarCalle(this.vehiculo.obtenerPosicion(), this.vehiculo.obtenerPosicion().obtenerPosicionDerecha()).aplicarPenalizacion(this.vehiculo);
        this.vehiculo.moverDerecha(estado);
    }
    public void moverIzquierda() {
        boolean estado = buscarCalle(this.vehiculo.obtenerPosicion(), this.vehiculo.obtenerPosicion().obtenerPosicionIzquierda()).aplicarPenalizacion(this.vehiculo);
        this.vehiculo.moverIzquierda(estado);
    }
    public void moverArriba() {
        boolean estado = buscarCalle(this.vehiculo.obtenerPosicion(), this.vehiculo.obtenerPosicion().obtenerPosicionArriba()).aplicarPenalizacion(this.vehiculo);
        this.vehiculo.moverArriba(estado);
    }
    public void moverAbajo() {
        boolean estado = buscarCalle(this.vehiculo.obtenerPosicion(), this.vehiculo.obtenerPosicion().obtenerPosicionAbajo()).aplicarPenalizacion(this.vehiculo);
        this.vehiculo.moverAbajo(estado);
    }






    /*

    public boolean verificarCalleDerecha(Vehiculo unVehiculo) {
        Posicion posicionVehiculo = unVehiculo.obtenerPosicion();
        Posicion posicionDestino = this.mapa[posicionVehiculo.obtenerFila()][posicionVehiculo.obtenerColumna()+1];
        return buscarCalle(posicionVehiculo, posicionDestino).aplicarPenalizacion(unVehiculo);
    }

    public boolean verificarCalleAbajo(Vehiculo unVehiculo) {
        // TODO: unVehiculo.moverAbajo(listaDeCalles);
        Posicion posicionVehiculo = unVehiculo.obtenerPosicion();
        Posicion posicionDestino = this.mapa[posicionVehiculo.obtenerFila()+1][posicionVehiculo.obtenerColumna()];
        return buscarCalle(posicionVehiculo, posicionDestino).aplicarPenalizacion(unVehiculo);
    }

    public boolean verificarCalleIzquierda(Vehiculo unVehiculo) {
        Posicion posicionVehiculo = unVehiculo.obtenerPosicion();
        Posicion posicionDestino = this.mapa[posicionVehiculo.obtenerFila()][posicionVehiculo.obtenerColumna()-1];
        return buscarCalle(posicionVehiculo, posicionDestino).aplicarPenalizacion(unVehiculo);
    }

    public boolean verificarCalleArriba(Vehiculo unVehiculo) {
        Posicion posicionVehiculo = unVehiculo.obtenerPosicion();
        Posicion posicionDestino = this.mapa[posicionVehiculo.obtenerFila()-1][posicionVehiculo.obtenerColumna()];
        return buscarCalle(posicionVehiculo, posicionDestino).aplicarPenalizacion(unVehiculo);
    }
*/
}