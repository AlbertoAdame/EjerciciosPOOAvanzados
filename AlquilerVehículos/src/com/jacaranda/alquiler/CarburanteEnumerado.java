package com.jacaranda.alquiler;

public enum CarburanteEnumerado {
	
	GASOIL(3.5), DIESEL(2);
		
	private double precio;

	private CarburanteEnumerado(double precio) {
		this.precio = precio;
	}
	
	public double getPrecio() {
		return precio;
	}
		
}
