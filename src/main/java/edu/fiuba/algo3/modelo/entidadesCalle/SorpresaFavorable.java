package edu.fiuba.algo3.modelo.entidadesCalle;

import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import edu.fiuba.algo3.modelo.jugador.Vehiculo;

import java.util.ArrayList;

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

    @Override
    public void levantarDeCalle(Vehiculo unVehiculo, int indiceSorpresa, ArrayList<Integer> indices){
        indices.add(indiceSorpresa);
    };
}