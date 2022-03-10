package com.jacaranda;

import java.util.Arrays;
import java.util.Objects;

public class Bloc {

	private static final int NUMERO_NOTAS_MAXIMA = 50;
	private int numNotas;
	private String nombre;
	private Nota[] notas;
	private NotaAlarma na;
	
	
	public Bloc(String nombre) {
		super();
		this.nombre = nombre;
		this.numNotas=0;
	}

	public String getNotas(int numero) {
		return notas[numero].getTexto();
	}

	public void updateNota(int numero, String texto) {
		this.notas[numero].setTexto(texto);
	}

	public void activa(int numero) {
		if(this.notas[numero] instanceof NotaAlarma) {
			na=(NotaAlarma)notas[numero];
			na.activar();
		}
	}
	
	public void desactiva(int numero) {
		if(this.notas[numero] instanceof NotaAlarma) {
			na=(NotaAlarma)notas[numero];
			na.desactivar();
		}
	}
 
	public static int getNumeroNotasMaxima() {
		return NUMERO_NOTAS_MAXIMA;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Bloc [numNotas=" + numNotas + ", nombre=" + nombre + ", notas=" + Arrays.toString(notas) + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bloc other = (Bloc) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	public String ordenaBloc() {
		String resultado="";
		for (int i = 0; i < numNotas; i++) {
			resultado=resultado+notas[i].toString();
		}
		return resultado;
	}
	
	public void añadirNota(String texto) {
		this.notas[numNotas]=new Nota(texto);
		numNotas++;
	}
	
	
}
