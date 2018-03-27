package org.mvpigs.dni;

import java.util.regex.*;

public class DNI {
    private String dni;
    private String matcherString = "";
    TablaAsignacion tabla;


    public DNI() {
        this.dni = "";
    }

    public DNI( String dni ) {
        this.dni = dni;
        tabla = new TablaAsignacion();
    }

    // Getters & Setters

    public String getDNI() {
        return this.dni;
    }

    private void setDNI(String dni) {
        this.dni = dni;
    }

    public String getMatcherString() {
        return this.matcherString;
    }

    public void setMatcherString(String match) {
        this.matcherString = match;
    }

    // Metodos

    public boolean comprobarDNI(){
        return checkParteNumerica() && checkLongitud() && parteAlfabetica() == tabla.calcularLetra(parteNumerica()); 
    }


    public int parteNumerica() {
            return Integer.parseInt(this.dni.substring(0, 8));
    }

    public char parteAlfabetica() {
        return this.dni.charAt(8);
    }

    public int obtenerResto() {
        return parteNumerica()%tabla.obtenerModulo();
    }

    public char obtenerLetra(){
        return tabla.calcularLetra(parteNumerica());
    }



    public boolean checkParteNumerica() {
        RegexDNI checkFormato = new RegexDNI();
        checkFormato.addRegex("NumeroDNI", "^[0-9]{8}(?=[a-zA-Z])(?![IÑOUiñou])|(?<=[XYZ])[0-9]{7}(?=[a-zA-Z])(?![IÑOUiñou])");
        for (String regex:checkFormato.getValues()) {
            Matcher matcher = crearMatcher(regex);
            while (matcher.find()) {
                this.setMatcherString(matcher.group());
                return true;
            }  
        }
        return false;
    }

    // privados

    private boolean checkLongitud() {
        if ( (esDNI() || esNIF()) && getDNI().length() == 9) {
            return true;
        }
        return false;
    }

    private Matcher crearMatcher(String regex) {
        Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(dni);
		return matcher;
    }

    private boolean esDNI() {
        if (getMatcherString().length() == 8){
            return true;
        }
        return false;
    }

    public boolean esNIF() {
        if (getMatcherString().length() == 7){
            this.setDNI(String.valueOf(tabla.getLetrasNIF().get(getDNI().substring(0, 1)) + getDNI().substring(1)));
            return true;
        }
        return false;
    }
}