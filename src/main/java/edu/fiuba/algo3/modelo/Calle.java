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

    public void aplicarPenalizacion(Vehiculo unVehiculo, Direccion unaDireccion, Posicion posicionVehiculo) {
        Movimiento movimiento = new Movimiento(posicionVehiculo, unaDireccion);
        for (ObjetoCalle unObjetoCalle : this.objetoCalles){
            reaccionarAObjeto(unVehiculo, unObjetoCalle, unaDireccion, movimiento);
        }
        movimiento.moverVehiculo();
    }


    private void reaccionarAObjeto(Vehiculo unVehiculo, ObjetoCalle unObjetoCalle, Direccion unaDireccion, Movimiento movimiento) {
        unVehiculo.modificarMovimientos(unObjetoCalle, unaDireccion, movimiento);
        unObjetoCalle.verificarTipo(unVehiculo);
    }

    public ArrayList<ObjetoCalle>

}

