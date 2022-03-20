package com.jacaranda.vehiculo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Coche extends Vehiculo {
	
	private EnumeracionCarburante carburante;

	public Coche(String matricula, String gama, LocalDate fechaSalida, String carburante) throws VehiculoException {
		super(matricula, gama, fechaSalida);
		
		this.carburante =  EnumeracionCarburante.valueOf(carburante.toUpperCase());
	}

	public String getCarburante() {
		return carburante.toString();
	}

	public void setCarburante(String carburante) {
		this.carburante = EnumeracionCarburante.valueOf(carburante.toUpperCase());
	}

	@Override
	public String toString() {
		return "Coche [carburante=" + carburante + super.toString() + "]";
	}
	
	public double getPrecio() {
		double resultado= super.getPrecio() + this.carburante.getPrecio()*super.getFechaEntrada().until(super.getFechaEntrada(), ChronoUnit.DAYS);
		return resultado;
	}

	

	

	
	
	
	
	
}
