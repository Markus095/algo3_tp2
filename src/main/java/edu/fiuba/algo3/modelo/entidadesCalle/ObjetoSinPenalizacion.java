package edu.fiuba.algo3.modelo.entidadesCalle;

import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;

public class ObjetoSinPenalizacion extends ObjetoCalle {
    int penalizacion;

    public ObjetoSinPenalizacion() {
        this.penalizacion = 0;
    }

    public String getNombre() {return "objetoSinPenalizacion";}

    public int reaccionar(int movimientos, TipoVehiculo unTipo) {
        movimientos += this.penalizacion;
        return movimientos;
    }
}