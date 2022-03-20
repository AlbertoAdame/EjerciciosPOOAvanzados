package com.jacaranda.vehiculo;

public enum EnumeracionGamas {
	ALTA(50), MEDIA(40), BAJA(30);
	
	private double precio;

	private EnumeracionGamas(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}
	
	
	
	
}
