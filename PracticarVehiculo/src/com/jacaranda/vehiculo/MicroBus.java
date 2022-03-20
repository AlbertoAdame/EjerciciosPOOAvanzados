package com.jacaranda.vehiculo;

import java.time.LocalDate;

public class MicroBus extends Vehiculo {
	private int plazas;
	private int PRECIO_PLAZA=5;

	public MicroBus(String matricula, String gama, LocalDate fechaSalida, int plazas) throws VehiculoException {
		super(matricula, gama, fechaSalida);
		this.setPlazas(plazas);
		;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) throws VehiculoException {
		if (plazas < 1)
			throw new VehiculoException("Numero de plazas inválido.");

		this.plazas = plazas;
	}

	
	@Override
	public String toString() {
		return "MicroBus [plazas=" + plazas + ", PRECIO_PLAZA=" + PRECIO_PLAZA  + super.toString()
				+ "]";
	}

	public double getPrecio() {
		return super.getPrecio() + this.plazas * PRECIO_PLAZA;

	}

}
