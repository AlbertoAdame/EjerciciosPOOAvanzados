package com.jacaranda.cartas;

import java.util.Objects;

public class Carta implements Comparable<Carta>{
	private int number;
	private String palo;

	public Carta(int number, String palo) {
		super();
		this.number = number;
		this.palo = palo;
	}

	public double getValor() {
		double resultado = 0;
		if (this.number > 7)
			resultado = 0.5;
		else
			resultado = this.number;
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
		String resultado;
		if (number == 8)
			resultado= "Carta [number= Sota, palo=" + palo + "]";
		else if (number == 9)
			resultado= "Carta [number= Caballo, palo=" + palo + "]";
		else if (number == 10)
			resultado= "Carta [number= Rey, palo=" + palo + "]";
		else 
			resultado= "Carta [number=" + number + ", palo=" + palo + "]";
		return resultado;
	}

	@Override
	public int compareTo(Carta o) {
		int resultado;
		resultado=this.getPalo().compareTo(o.getPalo());
		if(resultado==0)
			resultado=this.getNumber() - o.getNumber();
				
		return resultado;
	}

}
