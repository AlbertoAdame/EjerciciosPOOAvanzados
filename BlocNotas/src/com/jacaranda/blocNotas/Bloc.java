package com.jacaranda.blocNotas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.jacaranda.nota.Nota;
import com.jacaranda.nota.NotaAlarma;
import com.jacaranda.nota.NotaAlarmaException;

public class Bloc {

	private static final int NUMERO_NOTAS_MAXIMA = 50;
	private int numNotas;
	private String nombre;
	private Nota[] notas;

	public Bloc(String nombre) {
		super();
		this.nombre = nombre;
		this.numNotas = 0;
		this.notas = new Nota[NUMERO_NOTAS_MAXIMA];

	}

	public void anadirNota(String texto) throws BlocException {
		if (numNotas == NUMERO_NOTAS_MAXIMA)
			throw new BlocException("No se pueden introducir m�s notas.");

		notas[numNotas++] = new Nota(texto);

	}

	public void anadirNota(String texto, boolean activado) throws BlocException, NotaAlarmaException {
		if (numNotas == NUMERO_NOTAS_MAXIMA)
			throw new BlocException("No se pueden introducir m�s notas.");

		notas[numNotas++] = new NotaAlarma(texto, activado);
	}

	public void anadirNota(String texto, int minutos) throws BlocException, NotaAlarmaException {
		if (numNotas == NUMERO_NOTAS_MAXIMA)
			throw new BlocException("No se pueden introducir m�s notas.");

		notas[numNotas++] = new NotaAlarma(texto, minutos);
	}

	public void borrarNota(int posicion) throws BlocException {
		if (posicion >= numNotas || posicion < 0) {
			throw new BlocException("La posicion introducida no es v�lida.");
		}
		for (int i = posicion; i < numNotas - 1; i++) {
			notas[i] = notas[i + 1];
		}
		numNotas--;
	}

	public String getNota(int numero) throws BlocException { // Preguntar si puedo agregar un nuevo bloc exception
		if (notas[numero] == null) {
			throw new BlocException("Esta nota no existe.");
		}
		return notas[numero].getTexto();
	}

	public void updateNota(int numero, String texto) throws BlocException {
		if (notas[numero] == null) {
			throw new BlocException("Esta nota no existe.");
		}
		this.notas[numero].setTexto(texto);
	}

	public void activa(int numero) throws BlocException {
		if (notas[numero] == null) {
			throw new BlocException("Esta nota no existe.");
		}
		if (this.notas[numero] instanceof NotaAlarma) {
			((NotaAlarma) notas[numero]).activar();
		}
	}

	public void desactiva(int numero) throws BlocException {
		if (notas[numero] == null || numero > NUMERO_NOTAS_MAXIMA) {
			throw new BlocException("Esta nota no existe.");
		}
		if (this.notas[numero] instanceof NotaAlarma) {
			((NotaAlarma) notas[numero]).desactivar();
		}
	}

	public static int getNumeroNotasMaxima() {
		return NUMERO_NOTAS_MAXIMA;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumNotas() {// este getNumNotas no lo pide, pero lo hemos puesto para crear el array
								// auxiliar en el main
		return numNotas;
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder(this.nombre + "\n");
		for (int i = 0; i < numNotas; i++) {
			resultado.append(notas[i].toString() + "\n");
		}

		return resultado.toString();
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

//	public void ordenaBloc() {
//		int[] arrayAux;
//		Arrays.sort(arrayAux);
//	}

	public String arrayAux() {
		Nota[] arrayAux = new Nota[numNotas];
		for (int i = 0; i < numNotas; i++)
			arrayAux[i] = notas[i];

		Arrays.sort(arrayAux);
		StringBuilder resultado = new StringBuilder("Array ordenado");
		for (int i = 0; i < numNotas; i++) {
			resultado.append(arrayAux[i] + "\n");
		}
		return resultado.toString();
	}

	

}
