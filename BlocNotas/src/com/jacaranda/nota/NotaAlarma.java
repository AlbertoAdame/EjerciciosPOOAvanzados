package com.jacaranda.nota;

import java.time.LocalDateTime;

public class NotaAlarma extends Nota implements Activable{

	private LocalDateTime fechaAlarma;
	private static final int MINUTOS_REPETIR_POR_DEFECTO=5;
	private int minutosRepetir;
	private boolean activado;
	
	public NotaAlarma(String texto, Boolean activado) throws NotaAlarmaException {
		super(texto);
		this.fechaAlarma = LocalDateTime.now();
		if (this.fechaAlarma.isBefore(fechaCreacion)) {
			throw new NotaAlarmaException("La fecha alarma no puede ser anterior a la fecha de creaci�n.");
		}
		this.minutosRepetir = MINUTOS_REPETIR_POR_DEFECTO;
		this.activado = activado;
	}

	public NotaAlarma(String texto, int minutosRepetir) throws NotaAlarmaException {
		super(texto);
		this.fechaAlarma = LocalDateTime.now();
		if (this.fechaAlarma.isBefore(fechaCreacion)) {
			throw new NotaAlarmaException("La fecha alarma no puede ser anterior a la fecha de creaci�n.");
		}
		this.minutosRepetir = minutosRepetir;
	}

	public static int getMinutosRepetirPorDefecto() {
		return MINUTOS_REPETIR_POR_DEFECTO;
	}

	public void setFechaAlarma(LocalDateTime fechaAlarma) throws NotaAlarmaException {
		if (fechaAlarma.isBefore(this.getFechaCreacion())) {
			throw new NotaAlarmaException("La fecha alarma no puede ser anterior a la fecha de creaci�n.");
		}
		this.fechaAlarma = fechaAlarma;
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
		return super.toString() + "NotaAlarma [fechaAlarma=" + fechaAlarma + ", minutosRepetir=" + minutosRepetir + ", activado="
				+ activado + "]"; 
	}

	@Override
	public NotaAlarma clone() throws CloneNotSupportedException {
		NotaAlarma nueva= null;
		try {
			nueva = new NotaAlarma(super.texto,isActivado());
		} catch (NotaAlarmaException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido clonar.");
		}
		return nueva;
	}
	
	
	
	
}
