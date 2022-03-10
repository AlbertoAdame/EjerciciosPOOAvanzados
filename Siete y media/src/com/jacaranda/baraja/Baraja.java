package com.jacaranda.baraja;

import java.util.Arrays;

public abstract class Baraja implements Repartible {

	protected int numCartas;
	private int siguiente;
	protected Carta[] cartas;

	public Baraja(int numCartas) {
		super();
		this.numCartas = numCartas;
		this.siguiente = 0;
		this.cartas = new Carta[numCartas];
		barajar();

	}

	public void barajar() {
		int numCartasGeneradas = 0;
		while (numCartasGeneradas < this.numCartas) {
			int numero = generarNumero();
			String palo = generarPalo();
			Carta c1 = new Carta(numero, palo);
			boolean encontrado = false;
			for (int i = 0; i < numCartasGeneradas && encontrado; i++) {
				if (c1.equals(cartas[i]))
					encontrado = true;
			}
			if (!encontrado) {
				cartas[numCartasGeneradas++] = c1;
			}
		}
	}

	protected abstract String generarPalo();

//	@Override
//	public String toString() {
//		StringBuilder resultado = new StringBuilder();
//		for (int i = 0; i < numCartas; i++) {
//			resultado.append(baraja[i].toString() + "\n");
//		}
//		return resultado.toString();
//	}

	private int generarNumero() {
		int numero = (int) (Math.random() * (numCartas / 4)) + 1;
		return numero;
	}

	@Override
	public String toString() {
		return "Baraja [numCartas=" + numCartas + ", siguiente=" + siguiente + ", cartas=" + Arrays.toString(cartas)
				+ "]";
	}
	
	public void ordenar() {
		Arrays.sort(this.cartas);
	}

	public Carta getSiguiente() {
		if (siguiente == this.numCartas)
			siguiente = 0;
		Carta resultado = new Carta(cartas[siguiente].getNumber(), cartas[siguiente].getPalo());
		siguiente++;
		return resultado;
	}

}
