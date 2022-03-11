package com.jacaranda;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Vehiculo {
	
	private String matricula;
	private GamaEnumerado gama;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	
	public Vehiculo(String matricula, String gama, LocalDate fechaSalida) throws VehiculoException {
		super();
		this.matricula = matricula;
		this.gama = GamaEnumerado.valueOf(gama.toUpperCase());
		this.fechaEntrada = LocalDate.now();
		if (fechaSalida != null) {
			if (fechaSalida.isBefore(this.fechaEntrada))
				throw new VehiculoException("Fecha de salida debe ser posterior a fecha entrada");
		}
		
		this.fechaSalida = fechaSalida;
	}

	public String getGama() { //Aquí nos da un enumerado, entonces hay que cambiarlo por un String
		return gama.toString();
	}

	public void setGama(String gama) { //AQui igual, comprobar que nos de un String
		this.gama = GamaEnumerado.valueOf(gama.toUpperCase());
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getMatricula() {
		return matricula;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	
	
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", gama=" + gama + ", fechaEntrada=" + fechaEntrada
				+ ", fechaSalida=" + fechaSalida + "]";
	}

	public double getPrecio() {
		if (this.fechaSalida==null) {
			this.fechaSalida = LocalDate.now();
		}
		double resultado= gama.getPrecio()*fechaEntrada.until(fechaSalida, ChronoUnit.DAYS); //ella ha casteado a (int) antes de la fecha de salida, por si me da distinto
		return resultado;
	}
	
	
}
