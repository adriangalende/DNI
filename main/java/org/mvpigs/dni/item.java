package org.mvpigs.dni;


public class item {
	
	private String cadena;
	private Boolean numeroSano;
	private Boolean letraSana;
	private TablaAsignacion tabla;
	
	public DNI() {
	}
	
	
	public DNI(String cadena) {
		this.cadena = cadena;
		this.numeroSano = false;
		this.letraSana = false;
		this.tabla = new TablaAsignacion();
	}
	
	public Boolean checkLetra() {
		if(this.getNumeroSano()) {
			/*self.setLetraSana ( self.getParteAlfabeticaDni().isupper() and not self.getParteAlfabeticaDni().isdigit() and self.checkLetraValida() )*/
			this.setLetraSana(this.getParteAlfabeticaDni().equals(this.getParteAlfabeticaDni().toUpperCase()) && (!(Character.isDigit(this.getParteAlfabeticaDni().charAt(0))) && this.checkLetraValida()));
			return this.getLetraSana();
		}else {
			return false;
		}
	}
	
	
	public String obtenerLetra() {
		
		if(this.getNumeroSano()) {
			return this.tabla.calcularLetra(this.getParteNumericaDni());
		}else {
			return null;
		}
		
	}

	
	
	
	public Boolean checkDNI() {
		this.setNumeroSano(this.checkLongitud() && this.checkNumero());
		return this.getNumeroSano();
	}


	public String getCadena() {
		return cadena;
	}


	public void setCadena(String cadena) {
		this.cadena = cadena;
	}


	public Boolean getNumeroSano() {
		return numeroSano;
	}


	public void setNumeroSano(Boolean numeroSano) {
		this.numeroSano = numeroSano;
	}


	public Boolean getLetraSana() {
		return letraSana;
	}


	public void setLetraSana(Boolean letraSana) {
		this.letraSana = letraSana;
	}
	
	
	/* Parte privada */
	
	private Boolean checkLongitud(){
		return this.cadena.length() == 9;
	}
	
	
	private Boolean checkNumero() {	
		/*return self.dni[:-1].isdigit()*/
		return this.getCadena().substring(0, this.getCadena().length() -1).matches("-?\\d+(\\.\\d+)?");
		
	}
	
	private Boolean checkLetraValida() {
		if(this.getNumeroSano()) {
			return this.getParteAlfabeticaDni().equals(this.obtenerLetra());
		}else {
			return false;
		}
	}
	
	
	private String getParteAlfabeticaDni() {
		return this.getCadena().substring(this.getCadena().length()-1);
	}
	
	
	private int getParteNumericaDni(){
		if(this.getNumeroSano()) {
			return Integer.parseInt(this.getCadena().substring(0, this.getCadena().length() -1));
		}else{
			return 0;
		}
	}
	
	


}
