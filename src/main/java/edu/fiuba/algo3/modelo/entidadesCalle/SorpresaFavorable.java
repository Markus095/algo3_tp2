package edu.fiuba.algo3.modelo.entidadesCalle;

import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;

public class SorpresaFavorable extends ObjetoCalle {
    private float valor;

    public SorpresaFavorable() {
        this.valor = 0.8f;
    }
    public String getNombre() {return "sorpresa";}
    @Override
    public int reaccionar(int movimientos, TipoVehiculo unTipo) {
        return Math.round(this.valor * movimientos );
    }
}
