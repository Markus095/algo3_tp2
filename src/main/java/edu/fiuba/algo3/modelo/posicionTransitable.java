package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public class posicionTransitable extends Posicion{
    List<ObjetoCalle> ObjetosCalle      = new ArrayList<>();
    public posicionTransitable(int unaFila, int unaColumna) {
        super(unaFila, unaColumna);
    }
}

