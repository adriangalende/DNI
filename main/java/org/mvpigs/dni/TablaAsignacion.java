package org.mvpigs.dni;

import java.util.HashMap;
import java.util.Map;

public class TablaAsignacion{
    Map<String, Integer> letrasNIF = new HashMap<String, Integer>(){
        {
            put("X", 0);
            put("Y", 1);
            put("Z", 2);
        }       
    };

    char[] tabla = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' }; 
    /**\d{8}(?=[a-zA-Z])(?![IÑOUiñou])|(?<=[XYZ])\d{7}(?=[a-zA-Z])(?![IÑOUiñou]) */

    public char[] getTabla(){
        return tabla;
    }

    public char getLetra(int indice) {
        return tabla[indice];
    }

    public int obtenerModulo() {
        return this.tabla.length;
    }

    public char calcularLetra(int DNI) {
        return tabla[DNI%obtenerModulo()];
    }

    public Map<String, Integer> getLetrasNIF() {
        return this.letrasNIF;
    }
}