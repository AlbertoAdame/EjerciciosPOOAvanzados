package com.jacaranda.vehiculo;

public enum EnumeracionCarburante {
	GASOIL(3.5), DIESEL(2);
	
	public double precio;

	public double getPrecio() {
		return precio;
	}

	private EnumeracionCarburante(double precio) {
		this.precio = precio;
	}
	
	
}
