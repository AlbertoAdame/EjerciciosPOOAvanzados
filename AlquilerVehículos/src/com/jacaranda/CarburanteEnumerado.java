package com.jacaranda;

public enum CarburanteEnumerado {
	
	GASOLINA(3.5), GASOIL(2);
		
	private double precio;

	private CarburanteEnumerado(double precio) {
		this.precio = precio;
	}
	
	public double getPrecio() {
		return precio;
	}
		
}
