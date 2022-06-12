package edu.fiuba.algo3.modelo;

public abstract class Vehiculo {
    private Posicion posicionVehiculo;
    protected int cantidadDeMovimientos;

    public Vehiculo(int unaFila, int unaColumna) {
        this.posicionVehiculo = new Posicion(unaFila, unaColumna);
        this.cantidadDeMovimientos = 0;
    }


    public Posicion obtenerPosicionMoto() {
        return this.posicionVehiculo;
    }

    public void moverDerecha() {
        this.posicionVehiculo.moverDerecha();
        this.cantidadDeMovimientos++;
        System.out.print("En el vehiculo: ");
        System.out.print(this.cantidadDeMovimientos);
    }

    public void reaccionarAObjeto(Objeto unObjeto) {
        int movimientosActuales = this.cantidadDeMovimientos;
        this.cantidadDeMovimientos = unObjeto.obtenerPenalizacion(movimientosActuales);
    }

    public int obtenerCantidadMovimientos() {
        return this.cantidadDeMovimientos;
    }

    public void moverAbajo() {
        this.posicionVehiculo.moverAbajo();
        this.cantidadDeMovimientos++;
    }
}
