package org.mvpigs.dni;

public class TablaAsignacion{
    char[] tabla = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' }; 

    public char getLetra(int indice) {
        return tabla[indice];
    }
}