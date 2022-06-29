package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public class Calle {
    private ArrayList<ObjetoCalle> objetoCalles = new ArrayList();
    Posicion pos1;
    Posicion pos2;

    public Calle(Posicion pos1, Posicion pos2) {
        this.objetoCalles.add(new ObjetoSinPenalizacion());// NULL PATERN
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    public boolean vaDesdeHasta(Posicion unaPos1, Posicion unaPos2){
        return (unaPos1.esIgual(this.pos1) && unaPos2.esIgual(this.pos2));
    }

    public void guardarObjeto(ObjetoCalle unObjetoCalle) {
        objetoCalles.add(unObjetoCalle);
    }

    public Posicion aplicarPenalizacion(Vehiculo unVehiculo, Direccion unaDireccion, Posicion posicionVehiculo) {
        Posicion posicionSiguiente = new Posicion(0, 0);
        for (ObjetoCalle unObjetoCalle : this.objetoCalles){
            posicionSiguiente = reaccionarAObjeto(unVehiculo, unObjetoCalle, unaDireccion, posicionVehiculo);
            if (posicionVehiculo.esIgual(posicionSiguiente)) {
                return posicionVehiculo;
            }
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

    public Posicion obtenerPosicion1() {
        return this.pos1;
    }
    public Posicion obtenerPosicion2() {
        return this.pos2;
    }
    public Calle buscarCalle(Posicion pos1, Posicion pos2, ArrayList<Calle> calles) {
        // este metodo se puede implementar bien con streams
        for (Calle calle : calles) {
            if (calle.vaDesdeHasta(pos1, pos2) || calle.vaDesdeHasta(pos2,pos1)) return calle;
        }
        return new Calle(pos1,pos2);//a corregir
    }

}

