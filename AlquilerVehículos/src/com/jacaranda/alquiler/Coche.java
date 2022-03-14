package com.jacaranda.alquiler;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Coche extends Vehiculo {
	
	private CarburanteEnumerado carburante;

	public Coche(String matricula, String gama, LocalDate fechaSalida, String carburante) //aqui igual, cambiamos por String el carburante enumerado
			throws VehiculoException {
		super(matricula, gama, fechaSalida);
		this.carburante = CarburanteEnumerado.valueOf(carburante.toUpperCase());
	}

	public String getCarburante() { //Pasamos a String tb
		return carburante.toString();
	}

	public void setCarburante(String carburante) {
		this.carburante = CarburanteEnumerado.valueOf(carburante.toUpperCase());
;
	}

	@Override
	public String toString() {
		return "Coche [carburante=" + carburante +  super.toString() + "]";
	} //eso lo hemos añadido entrando en boton derecho, to String, inherited methods y elegimos el toString del padre y le añadimos carburante
	
	@Override // el override este se lo ha puesto ella, pq si hay dos metodos iguales te dice si se están pisando o no
	public double getPrecio() {
		return super.getPrecio() + this.carburante.getPrecio()* this.getFechaEntrada().until(this.getFechaSalida(), ChronoUnit.DAYS);
		//al get precio le ponemos el super para que sepa de donde viene, pq hay varios, sin embargo en clase coche no hay falta poner nada, y como hay varios va a coger el que más le convenga?? no estoy demasiado seguro
	}
}
