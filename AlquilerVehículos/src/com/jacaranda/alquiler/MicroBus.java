package com.jacaranda.alquiler;

import java.time.LocalDate;


public class MicroBus extends Vehiculo {
	
	private int numPlazas;
	private final int PRECIO_PLAZA = 5;
	
	public MicroBus(String matricula, String gama, LocalDate fechaSalida, int numPlazas) throws VehiculoException {
		super(matricula, gama, fechaSalida);
		this.numPlazas = numPlazas;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public int getPRECIO_PLAZA() {
		return PRECIO_PLAZA;
	}

	@Override
	public String toString() {
		return "MicroBus [numPlazas=" + numPlazas + ", PRECIO_PLAZA=" + PRECIO_PLAZA + super.toString() + "]";
	}

	public double getPrecio() {
		return super.getPrecio() + (5*this.numPlazas);
	}

	
	
	
	
}
