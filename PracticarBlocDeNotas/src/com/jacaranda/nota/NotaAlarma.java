package com.jacaranda.nota;

import java.time.LocalDateTime;

public class NotaAlarma extends Nota implements Activable {

	private LocalDateTime fechaAlarma;
	private static final int MINUTOS_REPETIR_POR_DEFECTO=5;
	private int minutosRepetir;
	private boolean activado;
	
	public NotaAlarma(String texto, LocalDateTime fechaAlarma, boolean activado) {
		super(texto);
		this.fechaAlarma = fechaAlarma;
		this.minutosRepetir = MINUTOS_REPETIR_POR_DEFECTO;
		this.activado = activado;
	}

	public NotaAlarma(String texto, LocalDateTime fechaAlarma, int minutosRepetir) throws NotaAlarmaException {
		super(texto);
		this.setFechaAlarma(fechaAlarma);;
		this.minutosRepetir = minutosRepetir;
		this.activado = true;
	}
	
	private void setFechaAlarma(LocalDateTime fechaAlarma) throws NotaAlarmaException {
		if(fechaAlarma== null || fechaAlarma.isBefore(super.getFechaCreacion()))
			throw new NotaAlarmaException("La fecha dada no es v�lida.");
		else
			this.fechaAlarma = fechaAlarma;
	}

	public static int getMinutosRepetirPorDefecto() {
		return MINUTOS_REPETIR_POR_DEFECTO;
	}
	
	public void activar() {
		this.activado=true;
	}
	
	public void desactivar() {
		this.activado=false;
	}
	
	public boolean isActivado() {
		return this.activado;
	}

	@Override
	public String toString() {
		return "NotaAlarma [fechaAlarma=" + fechaAlarma + ", minutosRepetir=" + minutosRepetir + ", activado="
				+ activado + "]";
	}
	
	

	
	
	
	
	
}
