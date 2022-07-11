package edu.fiuba.algo3.Vista;

import javafx.beans.property.SimpleStringProperty;

public class InfoJugada {
    SimpleStringProperty nombre;
    SimpleStringProperty cantidadMov;
    SimpleStringProperty posicion;
    public InfoJugada(String nombre, Integer cantidadMov, int posicion) {
        this.nombre =  new SimpleStringProperty(nombre);
        this.cantidadMov =  new SimpleStringProperty(cantidadMov.toString());
        this.posicion =  new SimpleStringProperty(String.valueOf(posicion));
    }
    public String getNombre(){
        return nombre.get();
    }
    public void setNombre(String fnombre){
        nombre.set(fnombre);
    }
    public String getCantidadMov(){
        return cantidadMov.get();
    }
    public void setCantidadMov(String fcantidadMov){
        cantidadMov.set(fcantidadMov);
    }

    public String getPosicion(){
        return posicion.get();
    }
    public void setPosicion(String fposicion){
        posicion.set(fposicion);
    }

}
