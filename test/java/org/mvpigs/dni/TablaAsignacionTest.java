package org.mvpigs.dni;

import org.junit.Test;
import static junit.framework.Assert.*;

import java.util.Arrays;



public class TablaAsignacionTest{
    @Test
    public void testTablaAsignacion() {
        TablaAsignacion tabla = new TablaAsignacion();
        System.out.println(Arrays.toString(tabla.tabla));
    }

    @Test
    public void testObtenerLetra() {
        TablaAsignacion tabla = new TablaAsignacion();
        assertEquals('G', tabla.getLetra(4));
        assertEquals('X', tabla.getLetra(10));
        assertEquals('T', tabla.getLetra(0));
    }

    @Test
    public void testCalcularLetra() {
        DNI dni = new DNI("43182653");
        TablaAsignacion tabla = new TablaAsignacion();
        assertEquals('S', tabla.calcularLetra(dni.parteNumerica()));
    }
}