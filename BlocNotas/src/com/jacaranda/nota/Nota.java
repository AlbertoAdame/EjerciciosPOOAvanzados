package com.jacaranda.nota;

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable<Nota> {

	protected static int codigoSiguiente = 1;
	protected int codigo;
	protected String texto;
	protected LocalDateTime fechaCreacion;
	protected LocalDateTime fechaUltimaModificacion;

	public Nota(String texto) {
		super();
		this.texto = texto;
		this.fechaCreacion = LocalDateTime.now();
		this.fechaUltimaModificacion=LocalDateTime.now();
		this.codigo = codigoSiguiente++;
	}
	

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.fechaUltimaModificacion = LocalDateTime.now();
		this.texto = texto;
	}

	public int getCodigo() {
		return codigo;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaUltimaModificacion;
	}

	public boolean isCreadoAnterior(Nota nota) throws NotaException {
		boolean resultado = false;
		if (nota.fechaCreacion == null) {
			throw new NotaException("La fecha de creaci�n es nula.");
		}

		if (nota.fechaCreacion.isBefore(this.getFechaCreacion())) {
			resultado = true;
		} 
		return resultado;
	}

	public boolean isModificado() throws NotaException {
		boolean resultado = false;
		if (this.fechaUltimaModificacion != null) {
			resultado = true;
		}
		return resultado;
	}

	public boolean isEmpty() {
//		boolean resultado = false;
//		if (this.texto == "") {
//			resultado = true;
//		}
		return this.texto.isEmpty();
//		return resultado;
	}

	public boolean isModificadoAnterior(Nota nota) {
		boolean resultado = false;
		if (nota.fechaUltimaModificacion.isBefore(this.fechaUltimaModificacion)) {
			resultado = true;
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Nota [codigo=" + codigo + ", texto=" + texto + ", fechaCreacion=" + fechaCreacion
				+ ", fechaModificacion=" + fechaUltimaModificacion + "]";
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
	public int compareTo(Nota o) {
		int resultado;
		resultado = this.texto.compareToIgnoreCase(o.getTexto());

		if (resultado == 0)
			resultado = this.fechaCreacion.compareTo(o.getFechaCreacion());
		return resultado;
	}

	@Override
	public Nota clone() throws CloneNotSupportedException {
		Nota nueva = new Nota(this.texto);
		nueva.codigo = this.codigo;
		nueva.fechaCreacion = this.fechaCreacion;
		nueva.fechaUltimaModificacion = this.fechaUltimaModificacion;
		return nueva;
	}

}
