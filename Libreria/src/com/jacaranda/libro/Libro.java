package com.jacaranda.libro;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Libro {
	private String titulo;
	private String autor;
	private String editorial;
	private LocalDate fechaEdicion;
	private String isbn;
	private int codigo;
	
	public Libro(String titulo, String autor, String editorial) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.fechaEdicion = LocalDate.now();
		this.isbn= generarIsbn();
		this.codigo = 0;
	}
	
	public Libro(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.fechaEdicion = LocalDate.now();
		this.isbn= generarIsbn();
		this.codigo = 0;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public LocalDate getFechaEdicion() {
		return fechaEdicion;
	}

	public int getCodigo() {
		return codigo;
	}

	private String generarIsbn() {
		String resultado ="";
		resultado += this.titulo.substring(0, 2);
		resultado += this.titulo.length();
		resultado += this.autor.substring(this.autor.length()-3);
		resultado += this.autor.length();
		return resultado;
	}


	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setFechaEdicion(LocalDate fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

	public String getIsbn() {
		return isbn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return "Libro : " + titulo + ". Autor: " + autor + ". ISBN: " + isbn + " Código:" + codigo;
	}
	
	
	public double masCaro(Libro other) throws LibroException {
		double resultado =getFechaEdicion().until(other.getFechaEdicion() ,ChronoUnit.DAYS);
		if (resultado < 0)
			throw new LibroException("Valor no válido");
		return resultado;
	}
	
	
}
