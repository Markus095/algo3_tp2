package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.VistaJuego;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.entidadesCalle.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class ControladorElegirAuto implements EventHandler<ActionEvent> {
    private Vehiculo vehiculo;
    public ControladorElegirAuto(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        File fileAcelerada = new File("src/main/Sonidos/y2mate.com_-_Race_Car_Sound_Effect_For_Download.mp3");
        Media mediaAcelerada = new Media(fileAcelerada.toURI().toString());
        MediaPlayer playerAcelerada = new MediaPlayer(mediaAcelerada);
        playerAcelerada.play();
        vehiculo.cambioTipoDeVehiculoA(new Auto(new Probabilidad(0.3f)));
    }
}
