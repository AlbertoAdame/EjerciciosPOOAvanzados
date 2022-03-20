package com.jacaranda.libro;

public class LibroPapel extends Libro {

	private double peso;
	private double precio;
	
	public LibroPapel(String titulo, String autor, String editorial, double peso, double precio) {
		super(titulo, autor, editorial);
		this.peso = peso;
		this.precio = precio;

		
	}

	public double getPeso() {
		return peso;
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return  "Autor: " + getAutor() + ", ISBM: " + getIsbn() + ", Código: " + getCodigo() +  ", Precio: " + precio + ", Peso:" + peso +  ", Libro: " + getTitulo() ;
	}

	public boolean masCaro(LibroDigital other) { 
		return getPrecio() < other.getPrecio();
	}
	
	
	
	
}
