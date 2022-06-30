package edu.fiuba.algo3;

import edu.fiuba.algo3.Vista.VistaJuego;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.tablero.*;
import edu.fiuba.algo3.modelo.entidadesCalle.*;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.controlador.ControladorComenzarJuego;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane contenedorMenu = new Pane();
        //primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setWidth(1000);
        primaryStage.setHeight(1000);
        primaryStage.setTitle("GPS");

        BotonGenerico botonDeInicio = new BotonComenzarJuego();
        botonDeInicio.setText("INICIO");
        Button botonDeMoto = new Button();
        botonDeMoto.setText("MOTO");
        Button botonDeAuto = new Button();
        botonDeAuto.setText("AUTO");
        Button botonDe4x4 = new Button();
        botonDe4x4.setText("4X4");

        TextField nombreJugador = new TextField();
        Label instruccion = new Label("Ingrese su nombre y elija su vehiculo");
        VBox contenedorVertical = new VBox(instruccion, nombreJugador, botonDeInicio);
        contenedorVertical.setPadding(new Insets(100));
        contenedorVertical.setSpacing(15);
        HBox contenedorDeBotones = new HBox(botonDeMoto, botonDeAuto, botonDe4x4);
        contenedorDeBotones.setPadding(new Insets(130));
        contenedorDeBotones.setSpacing(15);
        HBox contenedorHorizontal = new HBox(contenedorVertical, contenedorDeBotones);

        Vehiculo vehiculo = new Vehiculo(new Auto(new Probabilidad(0.5f)), new Posicion(0, 0));
        contenedorMenu.getChildren().add(contenedorHorizontal);

        ControladorElegirAuto controladorbotonAuto = new ControladorElegirAuto(vehiculo);
        botonDeAuto.setOnAction(controladorbotonAuto);
        ControladorElegirMoto controladorbotonMoto = new ControladorElegirMoto(vehiculo);
        botonDeMoto.setOnAction(controladorbotonMoto);
        ControladorElegirCuatroPorCuatro controladorbotonCuatroPorCuatro = new ControladorElegirCuatroPorCuatro(vehiculo);
        botonDe4x4.setOnAction(controladorbotonCuatroPorCuatro);


        Scene scene = new Scene(contenedorMenu, 1000, 1000);

        ControladorComenzarJuego controladorbotonjugar = new ControladorComenzarJuego(contenedorMenu, primaryStage, vehiculo, 1000);
        botonDeInicio.setOnAction(controladorbotonjugar);


        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                primaryStage.close();
            }
            if (e.getCode() == KeyCode.ENTER) {
                new VistaJuego().empezarJuego(primaryStage , contenedorMenu, vehiculo, 1000);
            }
        });

        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}