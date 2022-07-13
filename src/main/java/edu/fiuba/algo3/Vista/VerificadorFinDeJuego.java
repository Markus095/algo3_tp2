package edu.fiuba.algo3.Vista;
import edu.fiuba.algo3.controlador.ControladorSalir;
import edu.fiuba.algo3.modelo.jugador.Vehiculo;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.File;
import java.io.IOException;

public class VerificadorFinDeJuego {
    private Mapa mapa;
    private Pane contenedor;
    private Botones botones;
    private Stage stage;
    private Ranking ranking;
    private String nombreJugador;
    public VerificadorFinDeJuego(Stage stage, Pane contenedorJuego, Mapa unMapa, Botones botones, Ranking ranking, String nombreJugador) {
        this.mapa = unMapa;
        this.contenedor = contenedorJuego;
        this.botones = botones;
        this.stage = stage;
        this.ranking = ranking;
        this.nombreJugador = nombreJugador;
    }
    public void verificarFinJuego(Vehiculo vehiculo, int cantidadMovimientos) throws IOException {
        if (mapa.verificarFinDeJuego(vehiculo.obtenerPosicion())) {
            botones.deshabilitarBotones(true);
            contenedor.getChildren().clear();
            System.gc();
            ranking.agregarPartida((int)vehiculo.obtenerCantidadMovimientos(), this.nombreJugador);

            File file = new File("src/main/Imagenes/fondoFin.jpeg");
            Image imagen = new Image(file.toURI().toString(), 1000, 1000, true, false);
            ImageView imageView = new ImageView();
            imageView.setImage(imagen);
            imageView.setFitWidth(1000);
            imageView.setFitHeight(1000);
            contenedor.getChildren().add(imageView);

            TableView<InfoJugada> table = crearTablaPosiciones();

            File file1 = new File("src/main/Imagenes/finishboton.jpeg");
            Image img = new Image(file1.toURI().toString(), 70, 70, true, false);
            ImageView view = new ImageView();
            view.setImage(img);

            Button botonSalir = new Button();
            botonSalir.setGraphic(view);
            HBox contenedorDeBotones = new HBox(botonSalir);
            contenedorDeBotones.setPadding(new Insets(130));
            contenedorDeBotones.setSpacing(15);
            contenedorDeBotones.setLayoutX(100);
            contenedorDeBotones.setLayoutY(500);

            ControladorSalir controladorSalir = new ControladorSalir(stage);
            botonSalir.setOnAction(controladorSalir);
            contenedor.getChildren().addAll(contenedorDeBotones, table);
        }
    }
    private TableView<InfoJugada> crearTablaPosiciones() {
        TableView<InfoJugada> table = new TableView<InfoJugada>();
        final ObservableList<InfoJugada> rankingData = ranking.getRankingList();
        table.setEditable(true);

        TableColumn  nombreCol = new TableColumn("Nombre");
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn cantMovCol = new TableColumn("Cantidad de movimientos");
        cantMovCol.setCellValueFactory(new PropertyValueFactory<>("cantidadMov"));
        TableColumn posicionCol = new TableColumn("Posicion");
        posicionCol.setCellValueFactory(new PropertyValueFactory<>("posicion"));

        table.setItems(rankingData);
        table.getColumns().addAll(nombreCol, cantMovCol, posicionCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        final VBox vbox = new VBox(table);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        table.setLayoutX(600);
        table.setLayoutY(500);

        return table;
    }
}
