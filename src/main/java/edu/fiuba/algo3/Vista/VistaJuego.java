package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.jugador.Auto;
import edu.fiuba.algo3.modelo.jugador.Vehiculo;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import javafx.scene.layout.Pane;
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

    public Mapa getMapa() {
        return unMapa;
    }
    public Pane obtenerContenedor() {
        return contenedorJuego;
    }
    public void empezarJuego(Stage stage, Pane controlador) {
        this.contenedorJuego = controlador;
        this.stage = stage;
        this.botones = new Botones(this);
        this.unVehiculo = new Vehiculo(new Auto(new Probabilidad(0.5f)), new Posicion(0, 0));
        this.unMapa = new Mapa(100, 100);
        unMapa.inicializar();
        unMapa.posicionarVehiculo(unVehiculo);
        unMapa.asignarDestinoFinal(new Posicion(1, 3));

        this.contadorMovimientos = new ContadorMovimientos(contenedorJuego, (int)this.unVehiculo.obtenerCantidadMovimientos());
        this.vistaImagenes = new VistaImagenes(contenedorJuego);
        this.grillaMapa = new Grilla(contenedorJuego, 0 ,0, Color.LIMEGREEN, Color.BLACK, 40, 50,50, 0.8,0.5);


        actualizar();
    }

    public void actualizar() {
        contenedorJuego.getChildren().clear();
        System.gc();
        actualizarVistaMapa();
        actualizarTeclas();
        actualizarVistaBotones();
        actualizarContadorMovimientos();
    }

    private void actualizarContadorMovimientos() { contadorMovimientos.actualizar((int)this.unVehiculo.obtenerCantidadMovimientos());}

    private void actualizarVistaBotones() { botones.actualizarBotones(this); }
    private void actualizarVistaMapa() {
        grillaMapa.actualizar();
        Posicion posicionVehiculo = unVehiculo.obtenerPosicion();
        vistaImagenes.agregarImagenes(unMapa.obtenerCalles(), 40);
        vistaImagenes.agregarImagen("auto", posicionVehiculo, 40);
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
