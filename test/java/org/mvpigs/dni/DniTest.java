package org.mvpigs.dni;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Test;
import static junit.framework.Assert.*;

public class DNITest {
    @Test
    public void testLongitudDni() {
        DNI dni = new DNI("43182655V");
        assertEquals(9, dni.getDNI().length());
    }

    @Test
    public void testParteNumerica() {
        DNI dni = new DNI("43182655V");
        assertEquals(43182655, dni.parteNumerica());
    }

    @Test
    public void testParteAlfabetica() {
        DNI dni = new DNI("43182655V");
        assertEquals('V', dni.parteAlfabetica());
    }

    @Test
    public void testObtenerResto() {
        DNI dni = new DNI("43182655V");
        assertEquals(17, dni.obtenerResto());
    }

    @Test
    public void testObtenerLeta() {
        DNI dni = new DNI("43182655");    
        assertEquals('V', dni.obtenerLetra());
    }

    @Test
    public void testComprobarDNI() {
        DNI dni = new DNI("43182655V");
        assertEquals(true, dni.comprobarDNI());
    }

    @Test
    public void testArrayDNICorrectos() {
        String[] dniCorrectos = { "43182655V", "43182653S", "28441270E", "50485512Y", "28441270E", "33291020S",
                "63354599H", "33287887X", "37490778L", "04656946K", "89751615A", "51591203H" };

        for (String documento : dniCorrectos) {
            DNI dni = new DNI(documento);
            assertEquals(true, dni.comprobarDNI());
        }

    }

    @Test
    public void testRandomDNI() {
        String dniRandom;
        TablaAsignacion tabla = new TablaAsignacion();
        ArrayList<DNI> listaDNI = new ArrayList<DNI>();

        while (listaDNI.size() < 100) {
            dniRandom = "";
            for (int i = 0; i < 8; i++) {
                dniRandom += ThreadLocalRandom.current().nextInt(0, 9);
            }
            //Añadimos letra
            dniRandom += tabla.getTabla()[ThreadLocalRandom.current().nextInt(0, 9)];
            listaDNI.add(new DNI(dniRandom));
        }

        System.out.println("Comprobar dni (true = correcto ; false = incorrecto )");
        for (DNI dni : listaDNI) {
            System.out.println(dni.getDNI() + " : " + dni.comprobarDNI());
            if (!dni.comprobarDNI()) {
                System.out.println("La letra para el dni: " + dni.getDNI() + " deberia ser: "
                        + tabla.calcularLetra(dni.parteNumerica()));
            }
        }

    }
}
