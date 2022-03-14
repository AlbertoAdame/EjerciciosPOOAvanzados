package com.jacaranda.cartas;

import java.util.Arrays;

public class Baraja {
	protected int numCartas;
	protected int siguiente;
	private Carta[] baraja;

	public Baraja() {
		super();
		this.numCartas = 40;
		this.siguiente = 0;
		this.baraja = new Carta[numCartas];
	}

	public void barajar() {
		int contador = 0;
		while (contador < this.numCartas) {
			Carta ca = new Carta(generarNumero(), generarPalo());
			boolean encontrado = false;
			for (int i = 0; i < contador && !encontrado; i++) {
				if (baraja[i].equals(ca))
					encontrado = true;
			}
			if (!encontrado) {
				baraja[contador] = ca;
				contador++;
			}
				
		}
		siguiente = 0;

	}

	public Carta getSiguiente() {
		Carta resultado = new Carta(baraja[siguiente].getNumber(), baraja[siguiente].getPalo());
		siguiente++;
		return resultado;
	}

	private String generarPalo() {
		int numero;
		String resultado = "";

		numero = (int) (Math.random() * 4) + 1;
		if (numero == 1)
			resultado = "Oros";
		else if (numero == 2)
			resultado = "Copas";
		else if (numero == 3)
			resultado = "Bastos";
		else
			resultado = "Espadas";
		return resultado;
	}

	private int generarNumero() {
		return (int) (Math.random() * 10) + 1;// pq tengo un +1 al final
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(baraja);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Baraja other = (Baraja) obj;
		return Arrays.equals(baraja, other.baraja);
	}

	@Override
	public String toString() {
		StringBuilder resultado= new StringBuilder();
		for (int i = 0; i < numCartas; i++) {
			resultado.append(baraja[i].toString()+ "\n");
		}

		return resultado.toString();
	}
	
	public void ordenar() {
		Arrays.sort(this.baraja);
	}
	

}
