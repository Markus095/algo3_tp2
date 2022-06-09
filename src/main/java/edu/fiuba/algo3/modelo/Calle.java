package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public class Calle extends Posicion{
    List<ObjetoCalle> ObjetosCalle      = new ArrayList<>();
    public Calle(int unaFila, int unaColumna) {
        super(unaFila, unaColumna);
    }
}

