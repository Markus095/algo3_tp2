package edu.fiuba.algo3.modelo.entidadesCalle;

import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import edu.fiuba.algo3.modelo.jugador.Vehiculo;

import java.util.ArrayList;

public class SorpresaCambioVehiculo extends ObjetoCalle {
    public SorpresaCambioVehiculo(){
    }
    public String getNombre() {return "sorpresa";}

    public int reaccionar(int movimientos, TipoVehiculo unTipo) {
        return movimientos;
    }

    @Override
    public void verificarTipo(Vehiculo unVehiculo) {
        unVehiculo.cambioTipoDeVehiculo();
    }
    @Override
    public void levantarDeCalle(Vehiculo unVehiculo, int indiceSorpresa, ArrayList<Integer> indices){
        indices.add(indiceSorpresa);
        unVehiculo.modificarCantidadObjetos();
    };
}
