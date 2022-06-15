package edu.fiuba.algo3.modelo;

public abstract class TipoVehiculo {

    public abstract float reaccionarAPozo( float cantidadDeMovimientos);

    public float reaccionarASorpresaFavorable(float cantidadDeMovimientos){
        return cantidadDeMovimientos * 0.8f;
    };

    public float reaccionarASorpresaDesfavorable(float cantidadDeMovimientos){
        return cantidadDeMovimientos * 1.25f;
    };

    public abstract TipoVehiculo cambioVehiculo();
}
