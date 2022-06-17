package edu.fiuba.algo3.modelo;

public class Vehiculo {
    private Posicion posicionVehiculo;
    protected float cantidadDeMovimientos;
    private TipoVehiculo tipo;

    public Vehiculo(TipoVehiculo unTipo, int unaFila, int unaColumna) {
        this.posicionVehiculo = new Posicion(unaFila, unaColumna);
        this.cantidadDeMovimientos = 0;
        this.tipo = unTipo;
    }

    public Posicion obtenerPosicion() {
        return this.posicionVehiculo;
    }

    public boolean reaccionarAObjeto(Objeto unObjeto) {
        if (unObjeto.getClass().getSimpleName().equals("Pozo")){
            this.cantidadDeMovimientos = this.tipo.reaccionarAPozo( this.cantidadDeMovimientos);
        }
        else if (unObjeto.getClass().getSimpleName().equals("Piquete")){
            this.cantidadDeMovimientos = this.tipo.reaccionarAPiquete( this.cantidadDeMovimientos);
            return this.tipo.getClass().getSimpleName().equals("Moto");
        }
        else if(unObjeto.getClass().getSimpleName().equals("SorpresaFavorable")){
            this.cantidadDeMovimientos = this.tipo.reaccionarASorpresaFavorable(this.cantidadDeMovimientos);
        }
        else if (unObjeto.getClass().getSimpleName().equals("SorpresaDesfavorable")){
            this.cantidadDeMovimientos = this.tipo.reaccionarASorpresaDesfavorable(this.cantidadDeMovimientos);
        }
        else if (unObjeto.getClass().getSimpleName().equals("SorpresaCambioVehiculo")){
            this.tipo = this.tipo.cambioVehiculo();// STRATEGY O STATE, PASAR A INFORME
        }
        return true;
    }

    public float obtenerCantidadMovimientos() {
        return this.cantidadDeMovimientos;
    }

    public void moverAbajo() {
        this.posicionVehiculo.moverAbajo();
        this.cantidadDeMovimientos++;
    }

    public void moverArriba() {
        this.posicionVehiculo.moverArriba();
        this.cantidadDeMovimientos++;
    }

    public void moverIzquierda() {
        this.posicionVehiculo.moverIzquierda();
        this.cantidadDeMovimientos++;
    }

    public void moverDerecha() {
        this.posicionVehiculo.moverDerecha();
        this.cantidadDeMovimientos++;
    }

    public TipoVehiculo obtenerTipo() {
        return this.tipo;
    }
}
