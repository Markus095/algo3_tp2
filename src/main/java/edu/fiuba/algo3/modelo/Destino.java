package edu.fiuba.algo3.modelo;

public class Destino implements Contenido{
    private boolean finDeJuego;
    public Destino(){
        this.finDeJuego = false;
    }

    @Override
    public void reaccionarA(Moto moto) {
        this.finDeJuego = true;
    }
    @Override
    public boolean gano(){
        return finDeJuego;
    }
}
