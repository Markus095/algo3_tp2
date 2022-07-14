package edu.fiuba.algo3;

import edu.fiuba.algo3.Vista.VistaInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VistaInicio vistaInicio = new VistaInicio(primaryStage);
        Scene scene = vistaInicio.getScene();

        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}