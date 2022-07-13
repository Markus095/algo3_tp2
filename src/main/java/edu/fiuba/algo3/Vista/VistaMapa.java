package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.ArrayList;

public class VistaMapa {

    private int tileWidth = 64;
    private int tileHeigth = 64;

    private Grilla grillaMapa;
    private Pane contenedorJuego;
    private VistaImagenes vistaImagenes;
    private Mapa mapa;
    private float tamanio;
    private Posicion destinoFinal;

    public VistaMapa(Mapa mapa, Posicion destinoFinal){
        this.destinoFinal = destinoFinal;
        this.mapa = mapa;
        contenedorJuego = new Pane();
        int tamanioPantalla = 1000;
        int tamanioVereda = 4;
        this.tamanio = (float)tamanioPantalla/(float)(mapa.obtenerAncho() * tamanioVereda + 1);
        this.vistaImagenes = new VistaImagenes(contenedorJuego, tamanio, tamanioVereda);
        this.grillaMapa = new Grilla(contenedorJuego, Color.LIMEGREEN, Color.DARKGRAY,tamanioPantalla, mapa.obtenerAncho() * tamanioVereda + 1, mapa.obtenerAlto() * tamanioVereda + 1, 0.8,0.5, tamanioVereda);
    }
    public Pane inicializarVistaMapa(){
        vistaImagenes.agregarImagenes(this.mapa.obtenerCalles(), tamanio);
        vistaImagenes.agregarImagen("meta", destinoFinal, tamanio);
        return contenedorJuego;
    }

    public void addViewOnMap(String nombreImagen, Posicion posDestino, Posicion posAnterior) {
        vistaImagenes.agregarImagen("vacio", posAnterior, tamanio);
        vistaImagenes.agregarImagen(nombreImagen, posDestino, tamanio);
    }
}
