package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.jugador.Auto;
import edu.fiuba.algo3.modelo.jugador.Vehiculo;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import javafx.scene.layout.Pane;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;

public class VistaJuego {
    private Pane contenedorJuego;
    private Stage stage;
    private Vehiculo unVehiculo;
    private Mapa unMapa;
    private VistaImagenes vistaImagenes;
    private Botones botones;

    private ContadorMovimientos contadorMovimientos;
    private Grilla grillaMapa;
    private Posicion destinoFinal;
    private float tamanio;

    private RangoVision rangoVision;

    public Mapa getMapa() {
        return unMapa;
    }
    public Pane obtenerContenedor() {
        return contenedorJuego;
    }
    public void empezarJuego(Stage stage, Pane controlador, Vehiculo unVehiculo, double tamPantalla) {
        int cantidadColumnas = 15;
        int cantidadFilas = 15;
        int tamanioVereda = 4;
        this.contenedorJuego = controlador;

        this.tamanio = (float)tamPantalla/(float)(cantidadColumnas * tamanioVereda + 1);
        System.out.println("tamanio"+ tamanio);
        this.stage = stage;
        this.botones = new Botones(this);
        //this.unVehiculo = new Vehiculo(new Auto(new Probabilidad(0.5f)), new Posicion(0, 0));
        this.unVehiculo = unVehiculo;
        this.unMapa = new Mapa(cantidadFilas + 1, cantidadColumnas + 1);
        unMapa.inicializar();
        unMapa.posicionarVehiculo(unVehiculo);
        this.destinoFinal = new Posicion(3, 5);
        unMapa.asignarDestinoFinal(this.destinoFinal);


        this.rangoVision = new RangoVision(contenedorJuego, tamPantalla, tamanio, unVehiculo.obtenerPosicion());
        this.contadorMovimientos = new ContadorMovimientos(contenedorJuego, (int)this.unVehiculo.obtenerCantidadMovimientos());
        this.vistaImagenes = new VistaImagenes(contenedorJuego, tamanio, tamanioVereda);
        this.grillaMapa = new Grilla(contenedorJuego, Color.LIMEGREEN, Color.BLACK, tamPantalla, cantidadColumnas * tamanioVereda + 1, cantidadFilas * tamanioVereda + 1, 0.8,0.5, tamanioVereda);


        actualizar();
    }

    public void actualizar() {
        contenedorJuego.getChildren().clear();
        System.gc();
        actualizarVistaMapa();
        actualizarTeclas();
        actualizarVistaBotones();
        rangoVision.actualizarRangoVision(unVehiculo.obtenerPosicion());
        actualizarContadorMovimientos();
    }

    private void actualizarContadorMovimientos() { contadorMovimientos.actualizar((int)this.unVehiculo.obtenerCantidadMovimientos());}

    private void actualizarVistaBotones() { botones.actualizarBotones(this); }
    private void actualizarVistaMapa() {
        grillaMapa.actualizar();
        Posicion posicionVehiculo = unVehiculo.obtenerPosicion();
        vistaImagenes.agregarImagenes(unMapa.obtenerCalles(), tamanio);
        vistaImagenes.agregarImagen(unVehiculo.obtenerTipo().getClass().getSimpleName(), posicionVehiculo, tamanio);
        vistaImagenes.agregarImagen("meta", destinoFinal, tamanio);
    }
    public void actualizarTeclas(){
        stage.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                stage.close();
            }
            if (e.getCode() == KeyCode.W) {
                botones.moverArriba();
            }
            if (e.getCode() == KeyCode.S) {
                botones.moverAbajo();
            }
            if (e.getCode() == KeyCode.A) {
                botones.moverIzquierda();
            }
            if (e.getCode() == KeyCode.D) {
                botones.moverDerecha();
            }
        });
    }
}
