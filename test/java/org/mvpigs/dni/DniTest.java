package org.mvpigs.dni;

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

}
