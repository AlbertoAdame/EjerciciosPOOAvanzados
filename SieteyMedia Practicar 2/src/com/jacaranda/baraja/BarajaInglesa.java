package com.jacaranda.baraja;

public class BarajaInglesa extends Baraja {

	private static final int NUMERO_CARTAS_INGLESAS = 48;

	public BarajaInglesa() {
		super(NUMERO_CARTAS_INGLESAS);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String generarPalo() {
		int resultado = (int) ((Math.random() * 4) + 1);
		return PalosBarajaInglesa.values()[resultado].toString();
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("Baraja Inglesa \n");

		for (int i = 0; i < super.numCartas; i++) {
			if (super.cartas[i].getNumber() <= 10)
				resultado.append(super.cartas[i].getNumber());
			else {
				if (super.cartas[i].getNumber() == 10)
					resultado.append("J");
				else if (super.cartas[i].getNumber() == 11)
					resultado.append("Q");
				else
					resultado.append("K");
			}
			resultado.append(" " + super.cartas[i].getPalo() + "\n");

		}

		return resultado.toString();
	}

}
