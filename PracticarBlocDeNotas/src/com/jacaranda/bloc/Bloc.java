package com.jacaranda.bloc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

import com.jacaranda.nota.Nota;
import com.jacaranda.nota.NotaAlarma;
import com.jacaranda.nota.NotaAlarmaException;

public class Bloc  {
	private static final int NUMERO_NOTAS_MAXIMO = 10;
	private int numNotas;
	private String nombre;
	private Nota[] notas;

	public Bloc(String nombre) {
		super();
		this.numNotas = 0;
		this.nombre = nombre;
		this.notas = new Nota[NUMERO_NOTAS_MAXIMO];
	}

	public void annadirNota(String texto) throws BlocExecption {

		if (numNotas == NUMERO_NOTAS_MAXIMO)
			throw new BlocExecption("Bloc lleno.");

		notas[numNotas++] = new Nota(texto);

	}

	public void annadirNota(String texto, boolean activado) throws BlocExecption {

		if (numNotas == NUMERO_NOTAS_MAXIMO)
			throw new BlocExecption("Bloc lleno.");

		notas[numNotas++] = new NotaAlarma(texto, LocalDateTime.now(), activado);

	}

	public void annadirNota(String texto, int minutos) throws BlocExecption, NotaAlarmaException {

		if (numNotas == NUMERO_NOTAS_MAXIMO)
			throw new BlocExecption("Bloc lleno.");

		notas[numNotas++] = new NotaAlarma(texto, LocalDateTime.now(), minutos);

	}

//	public void borrarNota(int posicion) throws Exception {
//		if(posicion>=numNotas || posicion <0)
//			throw new Exception("Errpr");
//		for (int i = 0; i < numNotas-1; i++) {
//			notas[i]= notas[i+1];
//			
//		}numNotas--;
//	}
	
	
	public void borrarNota(int posicion) throws BlocExecption {
		if (posicion >= numNotas || posicion < 0)
			throw new BlocExecption("Esta posici�n no es v�lida.");
		for (int i = 0; i < numNotas - 1; i++) {
			notas[i] = notas[i + 1];

		}
		numNotas--;
	}

	public String getNota(int posicion) throws BlocExecption {
		if (notas[posicion] == null)
			throw new BlocExecption("Esta nota no es v�lida.");

		return notas[posicion].getTexto();
	}

	public void updateNota(int posicion, String texto) {
		this.notas[posicion].setTexto(texto);
	}

//	public void activa(int posicion) throws BlocExecption {
//		if(notas[posicion]==null)
//			throw new BlocExecption("Esta nota no es v�lida.");
//		if(notas[posicion] instanceof NotaAlarma)
//			((NotaAlarma) notas[posicion]).activar();
//	}
	
	public void activa(int posicion) throws BlocExecption {
		if (notas[posicion] == null)
			throw new BlocExecption("Esta nota no existe.");

		if (notas[posicion] instanceof NotaAlarma)
			((NotaAlarma) notas[posicion]).activar();
	}

	public void desactiva(int posicion) throws BlocExecption {
		if (notas[posicion] == null)
			throw new BlocExecption("Esta nota no existe");

		if (notas[posicion] instanceof NotaAlarma)
			((NotaAlarma) notas[posicion]).desactivar();
	}

	public static int getNumeroNotasMaximo() {
		return NUMERO_NOTAS_MAXIMO;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder(this.nombre+"\n");

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
	
	public String ordenaBloc() {
		Nota[] arrayAux = new Nota[numNotas];
		
		for (int i = 0; i < numNotas; i++) {
			arrayAux[i]=notas[i];	
		}
		
		Arrays.sort(arrayAux);
		StringBuilder resultado = new StringBuilder(this.nombre+ "ordenado \n");
		for (int i = 0; i < numNotas; i++) {
			resultado.append(arrayAux[i].toString()+"\n");
		}
		
		return resultado.toString();
	}

}
