package com.jacaranda.nota;

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable<Nota> {
	
	private static int codigoSiguiente=1;
	private int codigo;
	private String texto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaUltimaModificacion;
	
	
	public Nota(String texto) {
		super();
		this.codigo = codigoSiguiente++;
		this.texto = texto;
		this.fechaCreacion = LocalDateTime.now();
		this.fechaUltimaModificacion = LocalDateTime.now();
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.fechaUltimaModificacion=LocalDateTime.now();
		this.texto = texto;
	}


	public int getCodigo() {
		return codigo;
	}


	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}


	public LocalDateTime getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public boolean isModificado() {
		boolean resultado=false;
		if(this.fechaUltimaModificacion.isAfter(this.fechaCreacion))
			resultado=true;
		return resultado;
	}
	
	public boolean isEmpty() {
		return this.texto.isEmpty();
	}
	
	public boolean isCreadoAnterior(Nota nota) throws NotaException {
		boolean resultado= false;
		if(nota== null)
			throw new NotaException("Esta nota es nula.");
		else {
			if(nota.getFechaCreacion().isBefore(this.getFechaCreacion()))
				resultado=true;
		}return resultado;
	}
	
	public boolean isModificadoAnterior(Nota nota) throws NotaException {
		boolean resultado= false;
		if(nota== null)
			throw new NotaException("Esta nota es nula.");
		else {
			if(nota.getFechaUltimaModificacion().isBefore(this.getFechaUltimaModificacion()))
				resultado=true;
		}return resultado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaCreacion, texto);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(fechaCreacion, other.fechaCreacion) && Objects.equals(texto, other.texto);
	}


	@Override
	public String toString() {
		return "Nota [codigo=" + codigo + ", texto=" + texto + ", fechaCreaci�n=" + fechaCreacion
				+ ", fechaUltimaModificacion=" + fechaUltimaModificacion + "]";
	}


	@Override
	public int compareTo(Nota o) {
		
		int resultado= this.texto.compareToIgnoreCase(o.getTexto());
		if (resultado==0)
			resultado = this.fechaCreacion.compareTo(o.getFechaCreacion());
		return resultado;
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		Nota resultado = new Nota(this.texto);
		resultado.codigo = this.codigo;
		resultado.fechaCreacion = this.fechaCreacion;
		resultado.fechaUltimaModificacion = this.fechaUltimaModificacion;
		return resultado;
	}
	
	
	
	
	
	
	

}
