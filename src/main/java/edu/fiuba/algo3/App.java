package edu.fiuba.algo3;

import edu.fiuba.algo3.Vista.ContenedorMenu;
import edu.fiuba.algo3.Vista.VistaMapa;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Moto;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Vehiculo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    private VistaMapa vistaMapa;

    @Override
    public void start(Stage stage) {

        stage.setTitle("GPS CHALENGE");
        StackPane layout = new StackPane();
        Button botonDeInicio = new Button();
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

        var scene = new Scene(layout, 640, 480);
        stage.setScene(scene);

        Group root = new Group();
        Scene theScene = new Scene( root );
        stage.setScene( theScene );

        Canvas canvas = new Canvas( 800, 600 );
        root.getChildren().add( canvas);
        root.getChildren().add( contenedorHorizontal);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill( Color.BLUE );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
        gc.setFont( theFont );
        gc.fillText( "Bienvenidos a GPS Chalenge", 100, 50 );
        gc.strokeText( "Bienvenidos a GPS Chalenge", 100, 50 );

        Image icono = new Image( "file: iconoGps.png" );
        gc.drawImage( icono, 180, 100 );

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}