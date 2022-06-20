package edu.fiuba.algo3.modelo;

public class Piquete extends  Objeto {


    public Piquete() {
}

    @Override
    public int reaccionar(int movimientos, TipoVehiculo unTipo) {
        return unTipo.reaccionarAPiquete(movimientos);
    }

    @Override
    public boolean permitePaso(TipoVehiculo unTipo) {
        return unTipo.avanzo();
    }
}


