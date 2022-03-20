package com.jacaranda.libro;

public class LibroDigital extends Libro {
	private double precio;
	private EnumeracionFormatos formato;
	
	
	public LibroDigital(String titulo, String autor, String editorial, double precio, String formato) throws LibroDigitalException {
		super(titulo, autor, editorial);
		this.precio = precio;
		this.setFormato(formato);

	}


	public double getPrecio() {
		return precio;
	}


	public void setFormato(String formato) throws LibroDigitalException {
		try {
			this.formato = EnumeracionFormatos.valueOf(formato.toUpperCase());
		} catch (Exception e) {
			throw new LibroDigitalException("Este formato no es válido.");
		}
		
	}


	@Override
	public String toString() {
		return super.toString() + "Precio: " + precio + " Formato: " + formato + ".";
	}
	
	public boolean masCaro(LibroPapel other) { 
		return getPrecio() < other.getPrecio();
	}
	
	
}
