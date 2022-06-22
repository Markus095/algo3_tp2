package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Mapa;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public class VistaMapa {
    Mapa mapa;
    Pane pane;
    Canvas canvas;
    public VistaMapa(Mapa unMapa, Pane unPane, Canvas unCanvas){
        this.mapa = unMapa;
        this.pane = unPane;
        this.canvas = unCanvas;
    }

    public void mostrar(){
        VistaPosicion vistaPosicion = new VistaPosicion(10,10);

    }
}
