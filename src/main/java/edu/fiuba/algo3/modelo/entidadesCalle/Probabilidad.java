package edu.fiuba.algo3.modelo.entidadesCalle;

public class Probabilidad {
    private float probabilidad;
    public Probabilidad(float probabilidad){
        this.probabilidad = probabilidad;
    }
    public int aplicarPenalizacion( int movimientos){
        if (Math.random() <= this.probabilidad) {return movimientos + 3;}
        return movimientos;
    }
}
