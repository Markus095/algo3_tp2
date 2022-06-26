package edu.fiuba.algo3;

/*public class Main {
    public static void main(String[] args) {
        App.main(args);
    }
}*/
import edu.fiuba.algo3.Vista.VistaJuego;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.controlador.ControladorComenzarJuego;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane contenedorMenu = new Pane();
        primaryStage.setTitle("GPS");

        BotonGenerico botonDeInicio = new BotonComenzarJuego();
        //BorderPane.setAlignment(botonDeInicio, Pos.CENTER);

        contenedorMenu.getChildren().add(botonDeInicio);
        //contenedorMenu.setCenter(botonDeInicio);

        Scene scene = new Scene(contenedorMenu, 1000, 1000);

        ControladorComenzarJuego controladorbotonjugar = new ControladorComenzarJuego(contenedorMenu, primaryStage);
        botonDeInicio.setOnAction(controladorbotonjugar);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                primaryStage.close();
            }
            if (e.getCode() == KeyCode.ENTER) {
                new VistaJuego().empezarJuego(primaryStage , contenedorMenu);
            }
        });

        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}