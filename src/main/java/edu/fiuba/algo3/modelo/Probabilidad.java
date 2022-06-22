package edu.fiuba.algo3.modelo;

public class Probabilidad {
    public int aplicarPenalizacionConProbabilidad(float unaProbabilidad, int movimientos){
        if (Math.random() <= unaProbabilidad) {return movimientos + 3;}
        return movimientos;
    }
}
