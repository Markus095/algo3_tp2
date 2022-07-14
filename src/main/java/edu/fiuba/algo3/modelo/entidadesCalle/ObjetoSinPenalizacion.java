package edu.fiuba.algo3.modelo.entidadesCalle;

import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;

public class ObjetoSinPenalizacion extends ObjetoCalle {
    public String getNombre() {return "objetoSinPenalizacion";}

    public int reaccionar(int movimientos, TipoVehiculo unTipo) {
        return movimientos;
    }
}