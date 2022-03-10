package com.jacaranda;

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota {

	protected static int codigoSiguiente=1;
	protected int codigo=0;
	protected String texto;
	protected LocalDateTime fechaCreacion;
	protected LocalDateTime fechaUltimaModificacion;
	public Nota(String texto) {
		super();
		this.texto = texto;
		this.fechaCreacion=LocalDateTime.now();
		this.codigo=codigoSiguiente++;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
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
	
	public boolean isCreadoAnterior(Nota nota) {
		boolean resultado;
		if (nota.fechaCreacion.isBefore(this.getFechaCreacion())) {
			resultado=true;
		}
		else {
			resultado=false;
		}
		return resultado;
	}
	
	public boolean isModificado() {
		boolean resultado=false;
		if (this.fechaUltimaModificacion==null) {
			resultado=true;
		}
		return resultado;
	}
	public boolean isEmpty(){
		boolean resultado=false;
		if (this.texto=="") {
			resultado=true;
		}
		return resultado;
	}
	public boolean isModificadoAnterior(Nota nota) {
		boolean resultado=false;
		if (nota.fechaUltimaModificacion.isBefore(this.fechaUltimaModificacion)) {
			resultado=true;
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return "Nota [codigo=" + codigo + ", texto=" + texto + ", fechaCreacion=" + fechaCreacion
				+ ", fechaUltimaModificacion=" + fechaUltimaModificacion + "]";
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
	public int compareTo(Nota nota) {
		//HACER
		return 0;
	}
	
	
	
	
}
