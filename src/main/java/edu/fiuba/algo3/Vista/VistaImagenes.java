package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Calle;
import edu.fiuba.algo3.modelo.ObjetoCalle;
import edu.fiuba.algo3.modelo.Posicion;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import java.io.File;
import java.util.ArrayList;
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

        file = new File("src/main/Imagenes/piquete.png");
        Image imagen1 = new Image(file.toURI().toString(), 40, 40, true, false);
        imagenes.put("piquete", imagen1);

        file = new File("src/main/Imagenes/sorpresa.jpeg");
        Image imagen2 = new Image(file.toURI().toString(), 40, 40, true, false);
        imagenes.put("sorpresa", imagen2);

        file = new File("src/main/Imagenes/controlPolicial.png");
        Image imagen3 = new Image(file.toURI().toString(), 40, 40, true, false);
        imagenes.put("controlPolicial", imagen3);

    }
    private Image obtenerImagen(String nombre) {
        return imagenes.getOrDefault(nombre,null);
    }
    private ImageView crearImageView(Image imagen, Posicion posicion,int tam) {
        ImageView imageView = new ImageView();
        imageView.setImage(imagen);
        imageView.setLayoutX(posicion.obtenerColumna() * tam * (tam/10));
        imageView.setLayoutY(posicion.obtenerFila() * tam * (tam/10));
        imageView.setFitWidth(tam);
        imageView.setFitHeight(tam);
        return imageView;
    }
    private ImageView crearImageView2(Image imagen, Posicion posicion,int tam) {
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

    public void agregarImagenes(ArrayList<Calle> calles, int tam) {
        for (Calle calle : calles) {
            int i = 1;
            for (ObjetoCalle objeto : calle.obtenerObjetos()) {
                if (objeto.getNombre() != "objetoSinPenalizacion" && i < 3) {
                    Posicion posicionIntermedia = obtenerPosicionesIntermedias(calle, tam, i);
                    Image imagen = obtenerImagen(objeto.getNombre());
                    ImageView imageView = crearImageView2(imagen, posicionIntermedia, tam);
                    contenedor.getChildren().add(imageView);
                    i++;
                }
            }
        }
    }

    private Posicion obtenerPosicionesIntermedias(Calle unaCalle, int tam, int i) {
        if (unaCalle.obtenerPosicion1().obtenerFila() == unaCalle.obtenerPosicion2().obtenerFila()) {
            return (new Posicion(unaCalle.obtenerPosicion1().obtenerFila() * (tam/10), unaCalle.obtenerPosicion1().obtenerColumna() * (tam/10) + i));
        }
        return (new Posicion(unaCalle.obtenerPosicion1().obtenerColumna() * (tam/10) + i, unaCalle.obtenerPosicion1().obtenerColumna() * (tam/10)));
    }
}
