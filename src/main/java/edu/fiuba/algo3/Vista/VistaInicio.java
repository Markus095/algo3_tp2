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
    private HashMap<String, Integer> ranking;
    private ObservableList<InfoJugada> rankingList;

    public VistaInicio(Stage primaryStage) throws IOException {
        this.inicializarRanking();
        this.primaryStage = primaryStage;
        this.primaryStage.setResizable(false);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        this.primaryStage.setWidth(1000);
        this.primaryStage.setHeight(1000);
        this.primaryStage.setTitle("GPS");

        contenedorMenu = new Pane();
        this.reiniciar();

        this.scene = new Scene(contenedorMenu, 1000, 1000);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                this.primaryStage.close();
            }
        });

    }
    public Scene getScene() {
        return this.scene;
    }
    public void reiniciar() {
        contenedorMenu.getChildren().clear();
        System.gc();

        File file1 = new File("src/main/Imagenes/4x4boton.jpeg");
        Image img = new Image(file1.toURI().toString(), 70, 70, true, false);
        ImageView view = new ImageView();
        view.setImage(img);

        File file2 = new File("src/main/Imagenes/autoboton.jpeg");
        Image img2 = new Image(file2.toURI().toString(), 70, 70, true, false);
        ImageView view2 = new ImageView();
        view2.setImage(img2);

        File file3 = new File("src/main/Imagenes/motoboton.jpeg");
        Image img3 = new Image(file3.toURI().toString(), 70, 70, true, false);
        ImageView view3 = new ImageView();
        view3.setImage(img3);

        File file4 = new File("src/main/Imagenes/startboton2.jpeg");
        Image img4 = new Image(file4.toURI().toString(), 140, 70, true, false);
        ImageView view4 = new ImageView();
        view4.setImage(img4);

        File file5 = new File("src/main/Imagenes/instruccion.jpeg");
        Image img5 = new Image(file5.toURI().toString(), 320, 70, true, false);
        ImageView view5 = new ImageView();
        view5.setImage(img5);


        Button botonDeInicio = new Button();
        botonDeInicio.setGraphic(view4);

        Button botonDeMoto = new Button();
        botonDeMoto.setGraphic(view3);
        Button botonDeAuto = new Button();
        botonDeAuto.setGraphic(view2);
        Button botonDe4x4 = new Button();
        botonDe4x4.setGraphic(view);

        this.nombreJugador = new TextField();
        Label instruccion = new Label();
        instruccion.setGraphic(view5);
        this.nombreJugador.setFont(Font.font("Verdana", FontWeight.BOLD,20));
        VBox contenedorVertical = new VBox(instruccion, nombreJugador, botonDeInicio);
        contenedorVertical.setPadding(new Insets(100));
        contenedorVertical.setSpacing(15);
        HBox contenedorDeBotones = new HBox(botonDeMoto, botonDeAuto, botonDe4x4);
        contenedorDeBotones.setPadding(new Insets(130));
        contenedorDeBotones.setSpacing(15);
        HBox contenedorHorizontal = new HBox(contenedorVertical, contenedorDeBotones);
        contenedorHorizontal.setLayoutX(10);
        contenedorHorizontal.setLayoutY(500);

        File file = new File("src/main/Imagenes/fondoInicio.jpeg");
        Image imagen = new Image(file.toURI().toString(), 1000, 1000, true, false);
        ImageView imageView = new ImageView();
        imageView.setImage(imagen);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(1000);
        contenedorMenu.getChildren().add(imageView);

        contenedorMenu.getChildren().add(contenedorHorizontal);

        Vehiculo vehiculo = new Vehiculo(new Auto(new Probabilidad(0.5f)), new Posicion(0, 0));


        ControladorElegirAuto controladorbotonAuto = new ControladorElegirAuto(vehiculo);
        botonDeAuto.setOnAction(controladorbotonAuto);
        ControladorElegirMoto controladorbotonMoto = new ControladorElegirMoto(vehiculo);
        botonDeMoto.setOnAction(controladorbotonMoto);
        ControladorElegirCuatroPorCuatro controladorbotonCuatroPorCuatro = new ControladorElegirCuatroPorCuatro(vehiculo);
        botonDe4x4.setOnAction(controladorbotonCuatroPorCuatro);
        ControladorComenzarJuego controladorbotonjugar = new ControladorComenzarJuego(contenedorMenu, primaryStage, vehiculo, 1000, this);
        botonDeInicio.setOnAction(controladorbotonjugar);
    }

    public void agregarPartida(int obtenerCantidadMovimientos) throws IOException {
        this.ranking.put(this.nombreJugador.getText(), obtenerCantidadMovimientos);
        this.crear_archivo();
    }
    private void inicializarRanking() throws IOException {
        this.ranking = new HashMap<String, Integer>();
        BufferedReader csvReader = new BufferedReader(new FileReader("/home/azul/Documents/GitHub/algo3_tp2/src/main/java/edu/fiuba/algo3/Vista/ranking.csv"));
        String row = csvReader.readLine();
        while (row != null) {
            String[] data = row.split(",");
            ranking.put(data[0], Integer.valueOf(data[1]));
            row = csvReader.readLine();
        }
        csvReader.close();
    }
    private void crear_archivo() throws IOException {
        FileWriter csvWriter = new FileWriter("/home/azul/Documents/GitHub/algo3_tp2/src/main/java/edu/fiuba/algo3/Vista/ranking.csv");
        ranking = sortByValue(ranking);
        this.rankingList = FXCollections.observableArrayList();

        int i = 0; // todo arreglar esto feo
        for(Map.Entry<String, Integer> entry: ranking.entrySet()) {
            csvWriter.append(entry.getKey() + ',' + entry.getValue());
            csvWriter.append("\n");
            this.rankingList.add(new InfoJugada(entry.getKey(), entry.getValue(), i));
            i++;
        }

        csvWriter.flush();
        csvWriter.close();
    }
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        }.reversed());

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();

        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());

        }
        return temp;
    }

    public ObservableList<InfoJugada> getRankingList() {
        return rankingList;
    }
}
