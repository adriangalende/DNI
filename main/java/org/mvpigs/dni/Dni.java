package org.mvpigs.dni;

public class DNI {
    private String dni;

    public DNI() {
        this.dni = "";
    }

    public DNI( String dni ) {
        this.dni = dni;
    }

    // Getters & Setters

    public String getDNI() {
        return this.dni;
    }


    // Metodos

    public int parteNumerica() {
            return Integer.parseInt(this.dni.substring(0, 8));
    }

    public char parteAlfabetica() {
        return this.dni.charAt(8);
    }

    public int obtenerResto() {
        return parteNumerica()%23;
    }

    public char obtenerLetra(){

    }


}