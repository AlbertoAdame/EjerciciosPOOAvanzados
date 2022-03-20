package com.jacaranda.baraja;

public abstract class Baraja {
	protected int numCartas;
	private int siguiente;
	protected Carta[] cartas;
	
	public Baraja(int numCartas) {
		super();
		this.numCartas = numCartas;
		this.siguiente = 0;
		this.cartas = new Carta[numCartas]; 
	}
	
	public void barajar() {
		int numeroCartasGeneradas =0;
		if (numeroCartasGeneradas == numCartas)
			numeroCartasGeneradas=0;
		else {
			while(numCartas< numeroCartasGeneradas) {
				
			int numero= generarNumero();
			String palo = generarPalo();
			Carta c = new Carta(numero, palo);
			boolean encontrado = false;
			for (int i = 0; i <numeroCartasGeneradas && !encontrado; i++) {
				if (cartas[i].equals(c));
				encontrado = true;
			}
			
			if (!encontrado)
				cartas[numeroCartasGeneradas++]= c;
			}
		}
	}
	
	public abstract String generarPalo();
	
	private int generarNumero() {
		return (int) (Math.random()* (numCartas/4))+1;
	}

	@Override
	public String toString() {
		return "Baraja [numCartas=" + numCartas + ", siguiente=" + siguiente + "]";
	}
	
	public Carta getSiguiente() throws Exception {
		if(siguiente== numCartas)
			throw new Exception("Error");
		Carta resultado = new Carta(cartas[siguiente].getNumber(), cartas[siguiente].getPalo());
		siguiente ++;
		return resultado;
	}
	
	
}
