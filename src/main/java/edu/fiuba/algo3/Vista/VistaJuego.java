package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.controlador.ControladorDeBotones;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.entidadesCalle.ObjetoCalle;
import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import edu.fiuba.algo3.modelo.jugador.Vehiculo;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

public class VistaJuego implements Observer {
    private Pane contenedorJuego;
    private Stage stage;
    private Vehiculo unVehiculo;
    private Mapa unMapa;
    private VistaImagenes vistaImagenes;
    private ContadorMovimientos contadorMovimientos;
    private Grilla grillaMapa;
    private Posicion destinoFinal;
    private float tamanio;
    private VerificadorFinDeJuego verificadorFinDeJuego;
    private RangoVision rangoVision;
    private Ranking ranking;

    public void empezarJuego(Vehiculo unVehiculo, double tamPantalla, VistaInicio vistaInicio) throws IOException {

        this.contenedorJuego = new Pane();
        Scene scene = new Scene(this.contenedorJuego , 1000, 1000);
        int cantidadColumnas = 10;
        int cantidadFilas = 10;
        int tamanioVereda = 3;

        this.tamanio = (float)tamPantalla/(float)(cantidadColumnas * tamanioVereda + 1);
        this.stage = new Stage();
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.setWidth(1000);
        this.stage.setHeight(1000);
        this.unVehiculo = unVehiculo;
        this.unVehiculo.agregarObservador(this);
        this.unMapa = new Mapa(cantidadFilas + 1, cantidadColumnas + 1);
        this.destinoFinal = new Posicion(3, 5);
        this.ranking = new Ranking();

        unMapa.inicializar();
        unMapa.posicionarVehiculo(this.unVehiculo);
        unMapa.asignarDestinoFinal(this.destinoFinal);

        this.rangoVision = new RangoVision(contenedorJuego, tamPantalla, tamanio, this.unVehiculo.obtenerPosicion(), destinoFinal, tamanioVereda);
        this.contadorMovimientos = new ContadorMovimientos(contenedorJuego, (int)this.unVehiculo.obtenerCantidadMovimientos());
        this.vistaImagenes = new VistaImagenes(contenedorJuego, tamanio, tamanioVereda);
        this.grillaMapa = new Grilla(contenedorJuego, Color.LIMEGREEN, Color.DARKGRAY, tamPantalla, cantidadColumnas * tamanioVereda + 1, cantidadFilas * tamanioVereda + 1, 0.8,0.5, tamanioVereda);

        this.verificadorFinDeJuego = new VerificadorFinDeJuego(scene, this.stage, contenedorJuego, unMapa, this.ranking, vistaInicio.obtenerNombreJugador());
        scene.setOnKeyPressed(new ControladorDeBotones(unMapa, stage));
        this.stage.setScene(scene);
        this.stage.show();

        inicializarVistaJuego();
        vistaInicio.reiniciar();
    }

    private void inicializarVistaJuego() {
        Posicion posicionInicial = new Posicion(0,0);
        actualizarVistaMapa(DireccionAbajo.getDireccionAbajo(), posicionInicial);
        rangoVision.actualizarRangoVision(posicionInicial);
        actualizarContadorMovimientos(0);
    }

    private void actualizarContadorMovimientos(int cantidadDeMovimientos) { contadorMovimientos.actualizar(cantidadDeMovimientos);}


    private void actualizarVistaMapa(Direccion unaDireccion, Posicion posicionInicial) {
        Posicion posicionVehiculo = posicionInicial;
        vistaImagenes.agregarImagen("meta", destinoFinal, tamanio, DireccionArriba.getDireccionArriba());
        vistaImagenes.agregarImagenes(unMapa.obtenerCalles(), tamanio);
        vistaImagenes.agregarImagen(unVehiculo.obtenerTipo().getNombre(), posicionVehiculo, tamanio, unaDireccion);
    }

    @Override
    public void actualizar(Posicion posicion, TipoVehiculo tipoVehiculo, int cantidadMovimientos, Direccion direccion, ArrayList<ObjetoCalle> objetosLevantados) throws IOException {
        vistaImagenes.moverImagenVehiculo(unMapa.obtenerCalles(), posicion, tipoVehiculo, direccion, tamanio, objetosLevantados);
        rangoVision.actualizarRangoVision(posicion);
        actualizarContadorMovimientos(cantidadMovimientos);
        verificadorFinDeJuego.verificarFinJuego(posicion, cantidadMovimientos);
    }

}
