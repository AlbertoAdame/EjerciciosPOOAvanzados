package com.jacaranda.baraja;

import java.util.Arrays;

public abstract class Baraja implements Repartible {

	protected int numCartas;
	private int siguiente;
	protected Carta[] cartas;// mirar si estos arrays tiene que ir protected

	public Baraja(int numCartas) {
		super();
		this.numCartas = numCartas;
		this.siguiente = 0;
		this.cartas = new Carta[numCartas];
		barajar();
	}

	public void barajar() {
		int numeroCartasGeneradas = 0;
		while (numeroCartasGeneradas < this.numCartas) {
			int numero = generarNumero();
			String palo = generarPalo();
			Carta c = new Carta(numero, palo);
			boolean encontrado = false;
			for (int i = 0; i < numeroCartasGeneradas && !encontrado; i++) {
				if (cartas[i].equals(c))
					encontrado = true;
			}
			if (!encontrado)
				cartas[numeroCartasGeneradas++] = c;
		}
	}

	protected abstract String generarPalo();

	private int generarNumero() {
		return (int) (Math.random() * (numCartas / 4) + 1);
	}

	@Override
	public String toString() {
		return "Baraja [numCartas=" + numCartas + ", siguiente=" + siguiente + ", cartas=" + Arrays.toString(cartas)
				+ "]";
	}

	public Carta getSiguiente() {
		if (siguiente == this.numCartas)
			siguiente = 0;
		Carta nueva = new Carta(cartas[siguiente].getNumber(), cartas[siguiente].getPalo());
		siguiente++;
		return nueva;
	}

}
