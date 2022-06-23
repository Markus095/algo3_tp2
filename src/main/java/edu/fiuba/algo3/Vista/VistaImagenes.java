package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Posicion;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.File;
import java.util.HashMap;
import javafx.scene.image.ImageView;

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
    private Image obtenerImagen(String nombre) {
        return imagenes.getOrDefault(nombre,null);
    }
    private ImageView crearImageView(Image imagen, Posicion posicion,int tam) {
        ImageView imageView = new ImageView();
        imageView.setImage(imagen);
        imageView.setLayoutX(posicion.obtenerColumna() * tam);
        imageView.setLayoutY(posicion.obtenerFila() * tam);
        imageView.setFitWidth(tam);
        imageView.setFitHeight(tam);
        return imageView;
    }
    public ImageView agregarImagen(String nombre, Posicion posicion, int tam) {
        Image imagen = obtenerImagen(nombre);
        ImageView imageView = crearImageView(imagen,posicion,tam);
        contenedor.getChildren().add(imageView);
        return imageView;
    }
}
