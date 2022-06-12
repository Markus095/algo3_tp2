package edu.fiuba.algo3.modelo;

public class Mapa {
    private int fila;
    private  int columna;
    private Posicion posicionDestino;
    private Posicion [][] mapa;

    public Mapa(int unaFila, int unaColumna) {
        this.fila = unaFila;
        this.columna = unaColumna;
        this.mapa = new Posicion[this.fila][this.columna];
        for (int i = 0; i < fila; i ++) {
            for (int j = 0; j < columna; j++) {
                this.mapa[i][j] = new Posicion(i, j);
                Objeto ObjetoSinPenalizacion = new ObjetoSinPenalizacion();
                posicionarObjeto(ObjetoSinPenalizacion, i, j);
            }
        }
    }

    public int asignarDestinoFinal(int unaFila, int unaColumna) {
        this.posicionDestino = obtenerPosicion(unaFila, unaColumna);
        return 0;
    }

    public Posicion obtenerPosicion(int unaFila, int unaColumna) {
        return this.mapa[unaFila][unaColumna];
    }

    public Posicion obtenerPosicionLlegada() {
        return this.posicionDestino;
    }


    public boolean verificarFinDeJuego(Moto unaMoto, Posicion posicionLlegada) {
        return(unaMoto.obtenerPosicionMoto().obtenerFila() == posicionLlegada.obtenerFila() && unaMoto.obtenerPosicionMoto().obtenerColumna() == posicionLlegada.obtenerColumna());
    }

    public void posicionarObjeto(Objeto unObjeto, int unaFila, int unaColumna) {
        this.mapa[unaFila][unaColumna].guardarObjeto(unObjeto);
    }

    public void verificarCalleDerecha(Moto unaMoto) {
        Posicion posicionVehiculo = unaMoto.obtenerPosicionMoto();
        Objeto unObjeto = this.mapa[posicionVehiculo.obtenerFila()][posicionVehiculo.obtenerColumna()+1].obtenerObjeto();
        unaMoto.reaccionarAObjeto(unObjeto);
    }
}
