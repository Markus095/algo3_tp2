package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.entidadesCalle.*;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.tablero.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

import javafx.scene.image.ImageView;

public class VistaImagenes {
    private Pane contenedor;
    private HashMap<String, Image> imagenes;
    private int tamanioVereda;
    public VistaImagenes(Pane contenedor, double tam, int tamanioVereda) {
        this.contenedor = contenedor;
        this.imagenes = new HashMap<>();
        this.tamanioVereda = tamanioVereda;
        this.crearImagen(tam * 2);
    }
    private void crearImagen(double tam) {
        File file = new File("src/main/Imagenes/auto.png");
        Image imagen = new Image(file.toURI().toString(), tam, tam, true, false);
        imagenes.put("auto", imagen);

        file = new File("src/main/Imagenes/piquete.png");
        Image imagen1 = new Image(file.toURI().toString(), tam, tam, true, false);
        imagenes.put("piquete", imagen1);

        file = new File("src/main/Imagenes/sorpresa.png");
        Image imagen2 = new Image(file.toURI().toString(), tam, tam, true, false);
        imagenes.put("sorpresa", imagen2);

        file = new File("src/main/Imagenes/policia.png");
        Image imagen3 = new Image(file.toURI().toString(), tam, tam, true, false);
        imagenes.put("controlPolicial", imagen3);

        file = new File("src/main/Imagenes/meta.png");
        Image imagen4 = new Image(file.toURI().toString(), tam, tam, true, false);
        imagenes.put("meta", imagen4);

        file = new File("src/main/Imagenes/moto.png");
        Image imagen5 = new Image(file.toURI().toString(), tam, tam, true, false);
        imagenes.put("moto", imagen5);

        file = new File("src/main/Imagenes/4x4.png");
        Image imagen6 = new Image(file.toURI().toString(), tam, tam, true, false);
        imagenes.put("4x4", imagen6);

        file = new File("src/main/Imagenes/pozo.png");
        Image imagen7 = new Image(file.toURI().toString(), tam, tam, true, false);
        imagenes.put("pozo", imagen7);

        file = new File("src/main/Imagenes/vacio.png");
        Image imagen8 = new Image(file.toURI().toString(), tam, tam, true, false);
        imagenes.put("vacio", imagen8);


    }
    public Image obtenerImagen(String nombre) {
        return imagenes.getOrDefault(nombre,null);
    }
    private ImageView crearImageView(Image imagen, Posicion posicion,double tam) {
        ImageView imageView = new ImageView();
        imageView.setImage(imagen);
        imageView.setLayoutX(posicion.obtenerColumna() * tam * tamanioVereda);
        imageView.setLayoutY(posicion.obtenerFila() * tam * tamanioVereda);
        imageView.setFitWidth(tam);
        imageView.setFitHeight(tam);
        return imageView;
    }
    private ImageView crearImageView2(Image imagen, Posicion posicion,double tam) {
        ImageView imageView = new ImageView();
        imageView.setImage(imagen);
        imageView.setLayoutX(posicion.obtenerColumna());
        imageView.setLayoutY(posicion.obtenerFila());
        imageView.setFitWidth(tam);
        imageView.setFitHeight(tam);
        return imageView;
    }
    public void agregarImagen(String nombre, Posicion posicion, double tam) {
        Image imagen = obtenerImagen(nombre);
        ImageView imageView = crearImageView(imagen,posicion,tam);
        contenedor.getChildren().add(imageView);
    }

    public void agregarImagenes(ArrayList<Calle> calles, double tam) {
        for (Calle calle : calles) {
            int i = 1;
            for (ObjetoCalle objeto : calle.obtenerObjetos()) {
                if (objeto.getNombre() != "objetoSinPenalizacion" && i < 4) {
                    Posicion posicionIntermedia = obtenerPosicionesIntermedias(calle, tam, i);
                    Image imagen = obtenerImagen(objeto.getNombre());
                    ImageView imageView = crearImageView2(imagen, posicionIntermedia, tam);
                    contenedor.getChildren().add(imageView);
                    i++;
                }
            }
        }
    }

    private Posicion obtenerPosicionesIntermedias(Calle unaCalle, double tam, int i) {
        if (unaCalle.obtenerPosicion1().obtenerFila() == unaCalle.obtenerPosicion2().obtenerFila()) {
            return (new Posicion((int)(unaCalle.obtenerPosicion1().obtenerFila() * tam * tamanioVereda), (int)(unaCalle.obtenerPosicion1().obtenerColumna() * tam * tamanioVereda+ i * tam)));
        }
        return (new Posicion((int)(unaCalle.obtenerPosicion1().obtenerFila() * tam * tamanioVereda+ i * tam), (int)(unaCalle.obtenerPosicion1().obtenerColumna() * tam * tamanioVereda)));
    }
}
