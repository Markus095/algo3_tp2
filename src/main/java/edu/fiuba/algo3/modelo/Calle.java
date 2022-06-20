package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public class Calle {
    private ArrayList<Objeto> objetos = new ArrayList();
    Posicion pos1;
    Posicion pos2;

    public Calle(Posicion pos1, Posicion pos2) {
        this.objetos.add(new ObjetoSinPenalizacion());// NULL PATERN
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    public boolean vaDesdeHasta(Posicion unaPos1, Posicion unaPos2){
        return (unaPos1.esIgual(this.pos1) && unaPos2.esIgual(this.pos2));
    }

    public void guardarObjeto(Objeto unObjeto) {
        objetos.add(unObjeto);
    }

    public void aplicarPenalizacion(Vehiculo unVehiculo, Direccion unaDireccion, Posicion posicionVehiculo) {
        Movimiento movimiento = new Movimiento(posicionVehiculo, unaDireccion);
        for (Objeto unObjeto : this.objetos){
            reaccionarAObjeto(unVehiculo, unObjeto, unaDireccion, movimiento);
        }
        movimiento.moverVehiculo();
    }


    private void reaccionarAObjeto(Vehiculo unVehiculo, Objeto unObjeto, Direccion unaDireccion, Movimiento movimiento) {
        unVehiculo.modificarMovimientos(unObjeto, unaDireccion, movimiento);
        unObjeto.verificarTipo(unVehiculo);
    }

    private boolean puedeAvanzar(Vehiculo unVehiculo, Objeto unObjeto) {
        return unVehiculo.puedeAvanzar(unObjeto);
    }
}

