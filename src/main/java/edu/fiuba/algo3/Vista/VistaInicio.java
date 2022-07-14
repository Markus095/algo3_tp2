package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.jugador.Auto;
import edu.fiuba.algo3.modelo.jugador.Vehiculo;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.StageStyle;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class VistaInicio {
    private Scene scene;
    private Stage primaryStage;
    private TextField nombreJugador;
    private Pane contenedorMenu;
    private Ranking ranking;
    private Vehiculo vehiculo;

    public VistaInicio(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setResizable(false);
        this.primaryStage.setWidth(1000);
        this.primaryStage.setHeight(1000);
        this.primaryStage.setTitle("GPS");

        contenedorMenu = new Pane();
        this.reiniciar();
        this.scene = new Scene(contenedorMenu, 1000, 1000);

    }
    public Scene getScene() {
        return this.scene;
    }

    public void reiniciar() {
        contenedorMenu.getChildren().clear();
        System.gc();
        this.nombreJugador = new TextField();
        this.nombreJugador.setFont(Font.font("Verdana", FontWeight.BOLD,20));
        this.vehiculo = new Vehiculo(new Auto(new Probabilidad(0.5f)), new Posicion(0, 0));

        ImageView view4x4boton = crearView("src/main/Imagenes/4x4boton.jpeg", 70, 70);
        ImageView view2autoboton = crearView("src/main/Imagenes/autoboton.jpeg", 70, 70);
        ImageView view3motoboton = crearView("src/main/Imagenes/motoboton.jpeg", 70, 70);
        ImageView view4startboton = crearView("src/main/Imagenes/startboton2.jpeg", 140, 70);
        ImageView view5instruccion = crearView("src/main/Imagenes/instruccion.jpeg", 320, 70);
        ImageView viewFondoInicio = crearView("src/main/Imagenes/fondoInicio.jpeg", 1000, 1000);

        Button botonDeInicio = new Button();
        botonDeInicio.setGraphic(view4startboton);
        Button botonDeMoto = new Button();
        botonDeMoto.setGraphic(view3motoboton);
        Button botonDeAuto = new Button();
        botonDeAuto.setGraphic(view2autoboton);
        Button botonDe4x4 = new Button();
        botonDe4x4.setGraphic(view4x4boton);

        Label instruccion = new Label();
        instruccion.setGraphic(view5instruccion);
        VBox contenedorVertical = new VBox(instruccion, nombreJugador, botonDeInicio);
        contenedorVertical.setPadding(new Insets(100));
        contenedorVertical.setSpacing(15);
        HBox contenedorDeBotones = new HBox(botonDeMoto, botonDeAuto, botonDe4x4);
        contenedorDeBotones.setPadding(new Insets(130));
        contenedorDeBotones.setSpacing(15);
        HBox contenedorHorizontal = new HBox(contenedorVertical, contenedorDeBotones);
        contenedorHorizontal.setLayoutX(10);
        contenedorHorizontal.setLayoutY(500);

        contenedorMenu.getChildren().add(viewFondoInicio);
        contenedorMenu.getChildren().add(contenedorHorizontal);

        ControladorElegirAuto controladorbotonAuto = new ControladorElegirAuto(vehiculo);
        botonDeAuto.setOnAction(controladorbotonAuto);
        ControladorElegirMoto controladorbotonMoto = new ControladorElegirMoto(vehiculo);
        botonDeMoto.setOnAction(controladorbotonMoto);
        ControladorElegirCuatroPorCuatro controladorbotonCuatroPorCuatro = new ControladorElegirCuatroPorCuatro(vehiculo);
        botonDe4x4.setOnAction(controladorbotonCuatroPorCuatro);
        ControladorComenzarJuego controladorbotonjugar = new ControladorComenzarJuego(contenedorMenu, primaryStage, vehiculo, 1000, this);
        botonDeInicio.setOnAction(controladorbotonjugar);
    }

    public String obtenerNombreJugador() {
        return this.nombreJugador.getText();
    }

    private ImageView crearView(String path, int tamHorizontal, int tamVertical) {
        File file = new File(path);
        Image img = new Image(file.toURI().toString(), tamHorizontal, tamVertical, true, false);
        ImageView view = new ImageView();
        view.setImage(img);
        return view;
    }
}
