package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.entidadesCalle.ControlPolicial;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.jugador.Auto;
import edu.fiuba.algo3.modelo.jugador.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.jugador.Moto;
import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ControlPolicialTest {
    @Test
    public void unaMotoreaccionaAUnControlPolicialYNoEsPenalizada(){
        Probabilidad unaProbabilidad = Mockito.mock(Probabilidad.class);
        when(unaProbabilidad.aplicarPenalizacion(5)).thenReturn(5);
        TipoVehiculo moto = new Moto(unaProbabilidad);
        ControlPolicial control = new ControlPolicial();
        assertEquals(control.reaccionar(5, moto), 5);
    }

    @Test
    public void unaMotoreaccionaAUnControlPolicialYEsPenalizada(){
        Probabilidad unaProbabilidad = Mockito.mock(Probabilidad.class);
        when(unaProbabilidad.aplicarPenalizacion(5)).thenReturn(8);
        TipoVehiculo moto = new Moto(unaProbabilidad);
        ControlPolicial control = new ControlPolicial();
        assertEquals(control.reaccionar(5, moto), 8);
    }

    @Test
    public void unAutoreaccionaAUnControlPolicialYNoEsPenalizado(){
        Probabilidad unaProbabilidad = Mockito.mock(Probabilidad.class);
        when(unaProbabilidad.aplicarPenalizacion(5)).thenReturn(5);
        TipoVehiculo moto = new Auto(unaProbabilidad);
        ControlPolicial control = new ControlPolicial();
        assertEquals(control.reaccionar(5, moto), 5);
    }

    @Test
    public void unAutoreaccionaAUnControlPolicialYEsPenalizado(){
        Probabilidad unaProbabilidad = Mockito.mock(Probabilidad.class);
        when(unaProbabilidad.aplicarPenalizacion(5)).thenReturn(8);
        TipoVehiculo moto = new Auto(unaProbabilidad);
        ControlPolicial control = new ControlPolicial();
        assertEquals(control.reaccionar(5, moto), 8);
    }

    @Test
    public void una4x4reaccionaAUnControlPolicialYNoEsPenalizada(){
        Probabilidad unaProbabilidad = Mockito.mock(Probabilidad.class);
        when(unaProbabilidad.aplicarPenalizacion(5)).thenReturn(5);
        TipoVehiculo moto = new CuatroPorCuatro(unaProbabilidad);
        ControlPolicial control = new ControlPolicial();
        assertEquals(control.reaccionar(5, moto), 5);
    }

    @Test
    public void una4x4reaccionaAUnControlPolicialYEsPenalizada(){
        Probabilidad unaProbabilidad = Mockito.mock(Probabilidad.class);
        when(unaProbabilidad.aplicarPenalizacion(5)).thenReturn(8);
        TipoVehiculo moto = new CuatroPorCuatro(unaProbabilidad);
        ControlPolicial control = new ControlPolicial();
        assertEquals(control.reaccionar(5, moto), 8);
    }
}
