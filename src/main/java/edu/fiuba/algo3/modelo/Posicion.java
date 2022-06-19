package edu.fiuba.algo3.modelo;

public class Posicion {
    private int x;
    private int y;

    public Posicion(int unaFila, int unaColumna) {
        this.x = unaFila;
        this.y = unaColumna;
    }

    public Posicion obtenerPosicionArriba() {
        return new Posicion(this.x + 1, this.y);
    }
    public Posicion obtenerPosicionDerecha() {
        return new Posicion(this.x, this.y + 1);
    }
    public Posicion obtenerPosicionIzquierda() {
        return new Posicion(this.x, this.y - 1);
    }
    public Posicion obtenerPosicionAbajo() {
        return new Posicion(this.x - 1, this.y);
    }



    public boolean esIgual(Posicion otraPosicion){
        return (otraPosicion.obtenerFila() == this.x && otraPosicion.obtenerColumna() == this.y);
    }

    public int obtenerFila() {
        return this.x;
    }// y esto lo teniamos que sacar no?

    public int obtenerColumna() {
        return this.y;
    }
    public void moverAbajo() {
        this.x ++;
    }

    public void moverArriba() {
        this.x --;
    }

    public void moverIzquierda() {
        this.y --;
    }

    public void moverDerecha() { this.y ++; }


}
