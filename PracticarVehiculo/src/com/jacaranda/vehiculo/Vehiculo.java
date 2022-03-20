package com.jacaranda.vehiculo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Vehiculo {
	private String matricula;
	private EnumeracionGamas gama;
	private LocalDate fechaSalida;
	private LocalDate fechaEntrada;
	
	public Vehiculo(String matricula, String gama, LocalDate fechaSalida) throws VehiculoException {
		super();
		this.matricula = matricula;
		this.setGama(gama);;
		this.setFechaSalida(fechaSalida);
		this.fechaEntrada = LocalDate.now();
	}

	public String getGama() {
		return gama.toString();
	}

	public void setGama(String gama) {
		this.gama = EnumeracionGamas.valueOf(gama.toUpperCase());
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) throws VehiculoException {
		if(fechaSalida==null)
			throw new VehiculoException("Fecah nula");
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
		return "Vehiculo [matricula=" + matricula + ", gama=" + gama + ", fechaSalida=" + fechaSalida
				+ ", fechaEntrada=" + fechaEntrada + "]";
	}
	
	public double getPrecio() {
		double resultado=gama.getPrecio()*fechaEntrada.until(fechaSalida, ChronoUnit.DAYS);
		return resultado;
	}
	
}
