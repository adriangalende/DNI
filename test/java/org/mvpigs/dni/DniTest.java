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

    @Test
    public void testRegex() {
        String[] dniCorrectos = { "43182655V", "43182653S", "28441270E", "50485512Y", "28441270E", "33291020S",
        "63354599H", "33287887X", "37490778L", "04656946K", "89751615A", "51591203H" };

        for (String documento : dniCorrectos) {
            DNI dni = new DNI(documento);
            assertEquals(true, dni.checkParteNumerica());
        }

        //NIF formato incorrecto
        DNI nif = new DNI("X43182655V");
        assertEquals(false, nif.checkParteNumerica());

        //NIF formato correcto
        nif = new DNI("X4318265V");
        assertEquals(true, nif.checkParteNumerica());
    }

    @Test
    public void testDNIyNIF() {
        DNI dni;
        String[] casosTest = { // casos DNI PASS
            "78484464A","72376173A","01817200Q","95882054E","63587725Q",
            "26861694V","21616083Q","26868974Y","40135330P","89044648X",
            "80117501Z","34168723S","76857238R","66714505S","66499420A",
            "43182655V",
            // casos NIE PASS
            "X1234567L", "Y1234567X", "Z1234567R",
            // casos NIE FAIL
            "J1234567T", "H1234567T", "R1234567T",
            "X12345678X", "X1234T", "X1234567I"
            };
   
        for(String caso : casosTest){
            dni = new DNI(caso);
            if (dni.comprobarDNI()) {
                System.out.println("El caso " + caso + " es valido");
            } else {
                System.out.println("El caso " + caso + "no es valido");
            }
        }
    }
}
