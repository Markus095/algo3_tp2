package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.entidadesCalle.*;
import edu.fiuba.algo3.modelo.jugador.Vehiculo;
import edu.fiuba.algo3.modelo.patronObserver.Observable;
import edu.fiuba.algo3.modelo.patronObserver.Observer;
import javafx.beans.InvalidationListener;
import javafx.collections.ObservableArray;

import java.util.ArrayList;
import java.util.Collections;

public class Mapa implements Observable {
    private int cantidadFilas;
    private  int cantidadColumnas;
    private Vehiculo vehiculo;
    private boolean finDeJuego;
    private Posicion posicionDestino;
    private Posicion [][] mapa;
    private ArrayList<Calle> calles = new ArrayList<>();
    private ArrayList<Observer> observadores = new ArrayList<>();

    public Mapa(int unaCantidadFilas, int unaCantidadColumnas) {
        this.cantidadFilas = unaCantidadFilas;
        this.cantidadColumnas = unaCantidadColumnas;
        this.finDeJuego = false;
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

    public void asignarDestinoFinal(Posicion unaPosicion) {
        this.posicionDestino = unaPosicion;
    }
    public void inicializar(){
        ArrayList<ObjetoCalle> objetosCalle = new ArrayList<>(2);

        objetosCalle.add(new Pozo());
        objetosCalle.add(new SorpresaFavorable());
        objetosCalle.add(new SorpresaDesfavorable());
        objetosCalle.add(new Piquete());
        objetosCalle.add(new ControlPolicial());
        objetosCalle.add(new SorpresaCambioVehiculo());

        for (int j = 0; j < 2; j++) {
            for(int i = 0; i < calles.size(); i+=(Math.random()*100)%4){
                ObjetoCalle objeto = objetosCalle.remove(0);
                calles.get(i).guardarObjeto(objeto);
                objetosCalle.add(objeto);
                Collections.shuffle(objetosCalle);
            }
        }
    }
    public boolean verificarFinDeJuego(Posicion unaPosicion) {
        return this.posicionDestino.esIgual(vehiculo.obtenerPosicion());
    }

    public void posicionarObjeto(ObjetoCalle unObjetoCalle, Posicion pos1, Posicion pos2) {
        BuscadorCalle buscador = new BuscadorCalle();
        Calle calle = buscador.buscarCalle(this.calles, pos1, pos2);
        calle.guardarObjeto(unObjetoCalle);
    }

    public Posicion moverVehiculoEn(Direccion unaDireccion) {
        Posicion posicionVehiculo = this.vehiculo.moverseEn(this.calles, unaDireccion);
        this.finDeJuego = verificarFinDeJuego(posicionVehiculo);
        return posicionVehiculo;
    }

    public ArrayList<Calle> obtenerCalles() {
        return this.calles;
    }

    public int obtenerAncho() {
        return this.cantidadColumnas;
    }

    public int obtenerAlto() {
        return this.cantidadFilas;
    }

    public void agregarObservador(Observer observer) {
        observadores.add(observer);
    }

    public void notificarObservadores() {
        observadores.stream().forEach(observer -> observer.actualizar());
    }
}