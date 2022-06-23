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
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane grilla = new GridPane();
        Pane contenedorMenu = new Pane();
        primaryStage.setTitle("GPS");
        primaryStage.setScene(new Scene(grilla, 1920, 1080));


        BotonGenerico botonDeInicio = new BotonPlay();
        contenedorMenu.getChildren().add(botonDeInicio);

        Scene scene = new Scene(contenedorMenu);


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