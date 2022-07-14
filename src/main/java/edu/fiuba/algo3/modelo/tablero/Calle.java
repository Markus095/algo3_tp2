package edu.fiuba.algo3.modelo.tablero;
import edu.fiuba.algo3.modelo.entidadesCalle.ObjetoCalle;
import edu.fiuba.algo3.modelo.entidadesCalle.ObjetoSinPenalizacion;
import edu.fiuba.algo3.modelo.jugador.Vehiculo;
import edu.fiuba.algo3.modelo.direccion.Direccion;

import java.util.ArrayList;

public class Calle {
    private ArrayList<ObjetoCalle> objetoCalles = new ArrayList();
    Posicion pos1;
    Posicion pos2;
    boolean esHorizontal;

    public Calle(Posicion pos1, Posicion pos2, boolean esHorizontal) {
        this.objetoCalles.add(new ObjetoSinPenalizacion());// NULL PATERN
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.esHorizontal = esHorizontal;
    }


    public boolean vaDesdeHasta(Posicion unaPos1, Posicion unaPos2){
        return (unaPos1.esIgual(this.pos1) && unaPos2.esIgual(this.pos2));
    }

    public void guardarObjeto(ObjetoCalle unObjetoCalle) {
        if (objetoCalles.size() < 3) {
            objetoCalles.add(unObjetoCalle);
        }
    }


    public Posicion aplicarPenalizacion(Vehiculo unVehiculo, Direccion unaDireccion, Posicion posicionVehiculo) {
        Posicion posicionSiguiente = new Posicion(0, 0);
        ArrayList<Integer> indices = new ArrayList<>();
        ArrayList<ObjetoCalle> objetosLevantados = new ArrayList<>();
        for (ObjetoCalle unObjetoCalle : this.objetoCalles){
            posicionSiguiente = reaccionarAObjeto(unVehiculo, unObjetoCalle, unaDireccion, posicionVehiculo);
            unObjetoCalle.levantarDeCalle(unVehiculo, this.objetoCalles.indexOf(unObjetoCalle), indices);
            if (posicionVehiculo.esIgual(posicionSiguiente)) {
                return posicionVehiculo;
            }
        }
        for (Integer indice : indices) {
            objetosLevantados.add(this.objetoCalles.get(indice));
            unVehiculo.objetosLevantados = objetosLevantados;
            this.objetoCalles.remove(indice);
        }
        return posicionSiguiente;
    }

    private Posicion reaccionarAObjeto(Vehiculo unVehiculo, ObjetoCalle unObjetoCalle, Direccion unaDireccion, Posicion posicionVehiculo) {
        unVehiculo.modificarMovimientos(unObjetoCalle);
        unObjetoCalle.verificarTipo(unVehiculo);
        return unVehiculo.modificarPosicion(unObjetoCalle, posicionVehiculo, unaDireccion);
    }

    public ArrayList<ObjetoCalle> obtenerObjetos() {
        return this.objetoCalles;
    }

    public ArrayList<ObjetoCalle> obtenerObjetosPenalizadores() {
        ArrayList<ObjetoCalle> listaObjetosPenalizadores = new ArrayList<>(this.objetoCalles);
        listaObjetosPenalizadores.remove(0);
        return listaObjetosPenalizadores;
    }

    public Posicion obtenerPosicion1() {
        return this.pos1;
    }
    public Posicion obtenerPosicion2() {
        return this.pos2;
    }
    public boolean esHorizontal() {
        return esHorizontal;
    }

}

