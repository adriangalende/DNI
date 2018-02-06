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
}