package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.entidadesCalle.*;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.tablero.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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

    private void agregarImagenAImagenes(String path, String name, double tam) {
        File file = new File(path);
        Image imagen = new Image(file.toURI().toString(), tam, tam, true, false);
        imagenes.put(name, imagen);
    }

    private void crearImagen(double tam) {
        agregarImagenAImagenes("src/main/Imagenes/auto.png", (new Auto(new Probabilidad(0)).getClass().getSimpleName()), tam);
        agregarImagenAImagenes("src/main/Imagenes/piquete.png", "piquete", tam);
        agregarImagenAImagenes("src/main/Imagenes/sorpresa.png", "sorpresa", tam);
        agregarImagenAImagenes("src/main/Imagenes/policia.png","controlPolicial" , tam);
        agregarImagenAImagenes("src/main/Imagenes/meta.png", "meta", tam);
        agregarImagenAImagenes("src/main/Imagenes/moto.png", (new Moto(new Probabilidad(0)).getClass().getSimpleName()), tam);
        agregarImagenAImagenes("src/main/Imagenes/4x4.png", (new CuatroPorCuatro(new Probabilidad(0)).getClass().getSimpleName()), tam);
        agregarImagenAImagenes("src/main/Imagenes/pozo.png", "pozo", tam);
    }
    private Image obtenerImagen(String nombre) { return imagenes.getOrDefault(nombre,null); }

    private ImageView crearImageView(Image imagen, Posicion posicion,double tam, double factorMultiplicacion) {
        ImageView imageView = new ImageView();
        imageView.setImage(imagen);
        imageView.setLayoutX(posicion.obtenerColumna() * factorMultiplicacion);
        imageView.setLayoutY(posicion.obtenerFila() * factorMultiplicacion);
        imageView.setFitWidth(tam);
        imageView.setFitHeight(tam);

        return imageView;
    }
    public ImageView agregarImagen(String nombre, Posicion posicion, double tam, Direccion unaDireccion) {
        Image imagen = obtenerImagen(nombre);
        ImageView imageView = crearImageView(imagen,posicion,tam, tam * tamanioVereda);
        imageView.setRotate(unaDireccion.obtenerRotacion());
        contenedor.getChildren().add(imageView);
        return imageView;
    }

    public void agregarImagenes(ArrayList<Calle> calles, double tam) {
        for (Calle calle : calles) {
            int i = 1;
            for (ObjetoCalle objeto : calle.obtenerObjetos()) {
                if (objeto.getNombre() != "objetoSinPenalizacion") {
                    Posicion posicionIntermedia = obtenerPosicionesIntermedias(calle, tam, i);
                    Image imagen = obtenerImagen(objeto.getNombre());
                    ImageView imageView = crearImageView(imagen, posicionIntermedia, tam, 1);
                    contenedor.getChildren().add(imageView);
                    i++;
                }
            }
        }
    }

    private Posicion obtenerPosicionesIntermedias(Calle unaCalle, double tam, int i) {
        double factorMultiplicacion = tam * tamanioVereda;

        if (unaCalle.esHorizontal()) {
            return (new Posicion((int)(unaCalle.obtenerPosicion1().obtenerFila() * factorMultiplicacion), (int)(unaCalle.obtenerPosicion1().obtenerColumna() * factorMultiplicacion + i * tam)));
        }
        return (new Posicion((int)(unaCalle.obtenerPosicion1().obtenerFila() * factorMultiplicacion + i * tam), (int)(unaCalle.obtenerPosicion1().obtenerColumna() * factorMultiplicacion)));
    }

    public void moverImagenVehiculo(ArrayList<Calle> calles, Posicion posicion, TipoVehiculo tipoVehiculo, Direccion direccion, float tamanio, ArrayList<ObjetoCalle> objetosLevantados) {
        removerImagenes(4);
        for(ObjetoCalle objeto : objetosLevantados) {
        }
        agregarImagen(tipoVehiculo.getClass().getSimpleName(), posicion, tamanio, direccion);
    }

    private void removerImagenes(int cantidad) {
        for (int i = 0; i < cantidad; i ++) {
            contenedor.getChildren().remove(contenedor.getChildren().size()-1);
        }
    }


}
