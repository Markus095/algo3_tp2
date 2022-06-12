package edu.fiuba.algo3.modelo;

public class CuatroPorCuatro extends Vehiculo {
    private int cantidadPozos;
    public CuatroPorCuatro(int unaFila, int unaColumna) {
        super(unaFila, unaColumna);
        this.cantidadPozos = 0;
    }

    @Override
    public void  reaccionarAObjeto(Objeto unObjeto) {
        if (unObjeto.getClass().getName() == "Pozo") {
            this.cantidadPozos++;
        }
        if (this.cantidadPozos >=  3) {
            this.cantidadDeMovimientos = this.cantidadDeMovimientos + (unObjeto.obtenerPenalizacion() - 1);
        }
    }
}
