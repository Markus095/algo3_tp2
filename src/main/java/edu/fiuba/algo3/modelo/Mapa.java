package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Mapa {
    private int cantidadFilas;
    private  int cantidadColumnas;
    private  Vehiculo vehiculo;

    private Calle calleNoPermitida;
    private Posicion posicionDestino;
    private Posicion [][] mapa;
    private ArrayList<Calle> calles = new ArrayList<>();

    public Mapa(int unaCantidadFilas, int unaCantidadColumnas) {
        this.cantidadFilas = unaCantidadFilas;
        this.cantidadColumnas = unaCantidadColumnas;
        inicializarCalleNoPermitida();
        this.mapa = new Posicion[unaCantidadFilas][unaCantidadColumnas];
        for (int i = 0; i < unaCantidadFilas; i ++) {
            for (int j = 0; j < unaCantidadColumnas; j++) {
                this.mapa[i][j] = new Posicion(i, j);
                if(j != 0){ calles.add( new Calle(this.mapa[i][j-1], this.mapa[i][j])); }
                if(i != 0){ calles.add( new Calle(this.mapa[i-1][j], this.mapa[i][j])); }
            }
        }
    }

    private void inicializarCalleNoPermitida() {
        Posicion pos1 = new Posicion(-1, -1);
        this.calleNoPermitida = new Calle(pos1, pos1);
        NoPermitirPaso objeto = new NoPermitirPaso();
        posicionarObjeto(objeto, pos1, pos1);
    }
    public void posicionarVehiculo(Vehiculo unVehiculo) {
        this.vehiculo = unVehiculo;
    }

    public int asignarDestinoFinal(Posicion unaPosicion) {
        this.posicionDestino = unaPosicion;
        return 0;
    }
    public void inicializar(){
        ArrayList<ObjetoCalle> objetosCalle = new ArrayList<>();

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
        return this.posicionDestino.esIgual(unaPosicion);
    }

    public void posicionarObjeto(ObjetoCalle unObjetoCalle, Posicion pos1, Posicion pos2) {
        Calle calle = buscarCalle(pos1, pos2);
        calle.guardarObjeto(unObjetoCalle);
    }
//quizas hay que hacer un objeto calles?
    private Calle buscarCalle(Posicion pos1, Posicion pos2) {
        // este metodo se puede implementar bien con streams
        for (Calle calle : calles) {
            if (calle.vaDesdeHasta(pos1, pos2) || calle.vaDesdeHasta(pos2,pos1)) return calle;
        }
        return this.calleNoPermitida;
    }

    public void moverVehiculoEn(Direccion unaDireccion) {
        Posicion posicionVehiculo = this.vehiculo.moverseEn(this.calles, unaDireccion, this.calleNoPermitida);
        verificarFinDeJuego(posicionVehiculo);
    }

    public ArrayList<Calle> obtenerCalles() {
        return this.calles;
    }

}