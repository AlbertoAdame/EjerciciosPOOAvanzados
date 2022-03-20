package com.jacaranda.baraja;

import java.util.Objects;

public class Carta {
	private int number;
	private String palo;

	public Carta(int number, String palo) {
		super();
		this.number = number;
		this.palo = palo;
	}

	public double getValor() {
		double resultado = 0;
		if (this.number <= 7)
			resultado = this.number;
		else {
			if (this.number > 7)
				resultado = 0.5;
		}
		return resultado;

	}

	@Override
	public int hashCode() {
		return Objects.hash(number, palo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return number == other.number && Objects.equals(palo, other.palo);
	}

	public int getNumber() {
		return number;
	}

	public String getPalo() {
		return palo;
	}

	@Override
	public String toString() {
		return "Carta [number=" + number + ", palo=" + palo + "]";
	}

	@Override
	protected Carta clone() throws CloneNotSupportedException {
		Carta resultado = new Carta(number, palo);
		return resultado;
	}
	
	
}
