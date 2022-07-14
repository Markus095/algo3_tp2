package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.entidadesCalle.ObjetoCalle;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.tablero.BuscadorCalle;
import edu.fiuba.algo3.modelo.tablero.Calle;
import edu.fiuba.algo3.modelo.tablero.Posicion;

import java.io.IOException;
import java.util.ArrayList;

public class Vehiculo implements Observable {
    public ArrayList<ObjetoCalle> objetosLevantados;
    private Posicion posicionVehiculo;
    protected int cantidadDeMovimientos;
    private TipoVehiculo tipo;
    private ArrayList<Observer> listaObservadores;

    public Vehiculo(TipoVehiculo unTipo, Posicion unaPosicion) {
        this.objetosLevantados = new ArrayList<ObjetoCalle>();
        this.posicionVehiculo = unaPosicion;
        this.cantidadDeMovimientos = 0;
        this.tipo = unTipo;
        this.listaObservadores = new ArrayList<>();
    }

    public Posicion obtenerPosicion() {
        return this.posicionVehiculo;
    }

    public void modificarMovimientos(ObjetoCalle unObjetoCalle) {
        this.cantidadDeMovimientos = unObjetoCalle.reaccionar(this.cantidadDeMovimientos, this.tipo);
    }

    public int obtenerCantidadMovimientos() {
        return this.cantidadDeMovimientos;
    }

    public Posicion moverseEn(ArrayList<Calle> calles, Direccion unaDireccion) {
        BuscadorCalle buscador = new BuscadorCalle();
        Calle calle = buscador.buscarCalle(calles, this.posicionVehiculo, unaDireccion.obtenerPosicion(this.posicionVehiculo));
        this.posicionVehiculo = calle.aplicarPenalizacion(this, unaDireccion, this.posicionVehiculo);
        this.cantidadDeMovimientos++;
        notificarObservadores(unaDireccion);
        return this.posicionVehiculo;
    }

    public TipoVehiculo obtenerTipo() {
        return this.tipo;
    }

    public void cambioTipoDeVehiculo() {
        this.tipo = this.tipo.cambioVehiculo();
    }

    public void cambioTipoDeVehiculoA(TipoVehiculo unTipo) {
        this.tipo = unTipo;
    }


    public Posicion modificarPosicion(ObjetoCalle unObjeto, Posicion unaPosicion, Direccion unaDireccion) {
        Posicion posicionSiguiente = unObjeto.posicionSiguiente(unaPosicion, unaDireccion, this.tipo);
        return posicionSiguiente;
    }

    @Override
    public void agregarObservador(Observer observador) {
        listaObservadores.add(observador);
    }

    @Override
    public void notificarObservadores(Direccion unaDireccion) {
        listaObservadores.stream().forEach(observer -> {
            try {
                observer.actualizar(posicionVehiculo, tipo, cantidadDeMovimientos, unaDireccion, objetosLevantados);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
