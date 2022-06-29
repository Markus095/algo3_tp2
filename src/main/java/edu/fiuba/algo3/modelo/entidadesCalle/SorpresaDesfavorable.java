package edu.fiuba.algo3.modelo.entidadesCalle;

import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;

public class SorpresaDesfavorable extends ObjetoCalle {
    private float valor;

    public SorpresaDesfavorable() {
        this.valor = 1.25f;
    }
    public String getNombre() {return "sorpresa";}

    public int reaccionar(int movimientos, TipoVehiculo unTipo) {
        return Math.round(this.valor * movimientos);
    }
}
