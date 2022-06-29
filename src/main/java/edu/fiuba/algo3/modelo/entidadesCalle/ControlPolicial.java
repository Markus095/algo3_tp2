package edu.fiuba.algo3.modelo.entidadesCalle;

import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;

public class ControlPolicial extends ObjetoCalle {
    public String getNombre() {return "controlPolicial";}
    public int reaccionar(int movimientos, TipoVehiculo unTipo){
        return unTipo.reaccionarAControlPolicial(movimientos);
    }
}
