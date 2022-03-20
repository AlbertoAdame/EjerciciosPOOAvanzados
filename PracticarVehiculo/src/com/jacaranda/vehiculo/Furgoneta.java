package com.jacaranda.vehiculo;

import java.time.LocalDate;

public class Furgoneta extends Vehiculo {
	private double peso;
	private final  double PRECIO_PESO=0.5;
	
	
	public Furgoneta(String matricula, String gama, LocalDate fechaSalida, double peso) throws VehiculoException {
		super(matricula, gama, fechaSalida);
		this.peso = peso;
	}

	

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) throws VehiculoException {
		if (peso < 0)
			throw new VehiculoException("Peso no válido");
		this.peso = peso;
	}

	public double getPRECIO_PESO() {
		return PRECIO_PESO;
	}

	@Override
	public String toString() {
		return "Furgoneta [peso=" + peso + ", PRECIO_PESO=" + PRECIO_PESO + super.toString() + "]";
	}

	public double getPrecio() {
		return super.getPrecio()+ this.peso*PRECIO_PESO;
	}

	
	
	
}
