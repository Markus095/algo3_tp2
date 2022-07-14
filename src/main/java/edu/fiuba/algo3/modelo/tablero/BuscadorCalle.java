package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.entidadesCalle.NoPermitirPaso;

import java.util.ArrayList;

public class BuscadorCalle {
    private Calle calleNoPermitida;

    public BuscadorCalle() {
        Posicion pos1 = new Posicion(-1, -1);
        this.calleNoPermitida = new Calle(pos1, pos1, true);
        NoPermitirPaso objeto = new NoPermitirPaso();
        this.calleNoPermitida.guardarObjeto(objeto);
    }

    public Calle buscarCalle(ArrayList<Calle> calles, Posicion pos1, Posicion pos2) {
        for (Calle calle : calles) {
            if (calle.vaDesdeHasta(pos1, pos2) || calle.vaDesdeHasta(pos2,pos1)) return calle;
        }
        return this.calleNoPermitida;
    }
}
