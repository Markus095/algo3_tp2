package edu.fiuba.algo3.modelo.entidadesCalle;

import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;

public class Pozo extends ObjetoCalle {
    private int penalizacion;

    public Pozo() {
        this.penalizacion = 3;
    }
    public String getNombre() {return "pozo";}
    public int reaccionar(int movimientos, TipoVehiculo unTipo) {
        return unTipo.reaccionarAPozo(movimientos);
    }

}
