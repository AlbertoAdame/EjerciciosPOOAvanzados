package com.jacaranda;

import java.time.LocalDateTime;

public class NotaAlarma extends Nota implements Activable{

	private LocalDateTime fechaAlarma;
	private static final int MINUTOS_REPETIR_POR_DEFECTO=5;
	private int minutosRepetir;
	private boolean activado;
	
	public NotaAlarma(String texto, LocalDateTime fechaAlarma, Boolean activado) {
		super(texto);
		this.fechaAlarma = LocalDateTime.now();
		this.minutosRepetir = MINUTOS_REPETIR_POR_DEFECTO;
		this.activado = activado;
	}

	public NotaAlarma(String texto, LocalDateTime fechaAlarma, int minutosRepetir) {
		super(texto);
		this.fechaAlarma = LocalDateTime.now();
		this.minutosRepetir = minutosRepetir;
	}

	public static int getMinutosRepetirPorDefecto() {
		return MINUTOS_REPETIR_POR_DEFECTO;
	}

	private void setFechaAlarma(LocalDateTime fechaAlarma) {
		this.fechaAlarma = fechaAlarma;
	}
	
	public void activar() {
		this.activado=true;
	}
	
	public void desactivar() {
		this.activado=false;
	}
	
	public boolean isActivado() {
		boolean resultado;
		if (this.activado==true) {
			resultado=true;
		}
		else {
			resultado=false;
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "NotaAlarma [fechaAlarma=" + fechaAlarma + ", minutosRepetir=" + minutosRepetir + ", activado="
				+ activado + "]";
	}
	
}
