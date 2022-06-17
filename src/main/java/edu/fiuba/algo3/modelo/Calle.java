package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public class Calle {
    private ArrayList<Objeto> objetos = new ArrayList<>();
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

    public boolean aplicarPenalizacion(Vehiculo unVehiculo) {
        for(Objeto unObjeto: objetos){
            if(!unVehiculo.reaccionarAObjeto(unObjeto)) {
                return false;
            }
        }
        return true;
    }
}
