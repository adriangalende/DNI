package org.mvpigs.dni;

public class DNI {
    String dni;

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

    public int parteNumerica(){
        return Integer.parseInt(this.dni.substring(0, 8));
    }
}