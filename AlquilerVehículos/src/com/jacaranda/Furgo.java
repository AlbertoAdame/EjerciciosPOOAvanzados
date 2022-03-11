package com.jacaranda;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Furgo extends Vehiculo {
	
	private double pesoMax;
	private final double PRECIOPESO=0.5;
	
	public Furgo(String matricula, String gama, LocalDate fechaSalida, double peso) throws VehiculoException {
		super(matricula, gama, fechaSalida);
		this.pesoMax = peso;
		
	}
	
	public double getPesoMax() {	
		return pesoMax;
	}

	public void setPesoMax(double pesoMax) {
		this.pesoMax = pesoMax;
	}

	public double getPRECIOPESO() {
		return PRECIOPESO;
	}

	@Override
	public String toString() {
		return "Furgo [pesoMax=" + pesoMax + ", toString()=" + super.toString() + "]";
	}


	
	
}
