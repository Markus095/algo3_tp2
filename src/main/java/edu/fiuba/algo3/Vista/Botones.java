package edu.fiuba.algo3.Vista;
import edu.fiuba.algo3.controlador.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Botones{
    private Pane contenedor;
    private Button botonIzquierda;
    private Button botonDerecha;
    private Button botonArriba;
    private Button botonAbajo;

    public Botones(VistaJuego juego) {
        this.contenedor = juego.obtenerContenedor();

        Button botonArriba = crearBoton(0,0,0);
        ControladorMoverVehiculoArriba arriba = new ControladorMoverVehiculoArriba(juego);
        botonArriba.setOnAction(arriba);
        this.botonArriba = botonArriba;

        Button botonAbajo = crearBoton(0,0,0);
        ControladorMoverVehiculoAbajo abajo = new ControladorMoverVehiculoAbajo(juego);
        botonAbajo.setOnAction(abajo);
        this.botonAbajo = botonAbajo;

        Button botonDerecha = crearBoton(0,0,0);
        ControladorMoverVehiculoDerecha derecha = new ControladorMoverVehiculoDerecha(juego);
        botonDerecha.setOnAction(derecha);
        this.botonDerecha = botonDerecha;

        Button botonIzquierda = crearBoton(0,0,0);
        ControladorMoverVehiculoIzquierda izquierda = new ControladorMoverVehiculoIzquierda(juego);
        botonIzquierda.setOnAction(izquierda);
        this.botonIzquierda = botonIzquierda;
    }
    public void actualizarBotones(VistaJuego juego) {

        contenedor.getChildren().add(botonIzquierda);
        contenedor.getChildren().add(botonDerecha);
        contenedor.getChildren().add(botonArriba);
        contenedor.getChildren().add(botonAbajo);

    }
    public void moverArriba() { this.botonArriba.fire(); }
    public void moverAbajo() { this.botonAbajo.fire(); }
    public void moverDerecha() { this.botonDerecha.fire(); }
    public void moverIzquierda() { this.botonIzquierda.fire(); }

    private Button crearBoton(int x,int y, int scale) {
        Button boton = new Button();
        boton.setScaleX(scale);
        boton.setLayoutX(x);
        boton.setLayoutY(y);
        contenedor.getChildren().add(boton);
        return boton;
    }

    public void deshabilitarBotones(boolean habilitar) {
        this.botonAbajo.setDisable(habilitar);
        this.botonArriba.setDisable(habilitar);
        this.botonIzquierda.setDisable(habilitar);
        this.botonDerecha.setDisable(habilitar);
    }
}
