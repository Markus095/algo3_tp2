package edu.fiuba.algo3.Vista;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.File;
import java.util.HashMap;

public class VistaImagenes {
    private Pane contenedor;
    private HashMap<String, Image> imagenes;

    public VistaImagenes(Pane contenedor) {
        this.contenedor = contenedor;
        this.imagenes = new HashMap<>();
        this.crearImagen();
    }
    private void crearImagen() {
        File file = new File("src/main/Imagenes/auto.jpeg");
        Image imagen = new Image(file.toURI().toString(), 40, 40, true, false);
        imagenes.put("auto", imagen);
    }
}
