package com.jacaranda.baraja;

public class BarajaEspannola extends Baraja {

	private static final int CARTAS_ESPANNOLA = 40;

	public BarajaEspannola() {
		super(CARTAS_ESPANNOLA);

	}

	@Override
	protected String generarPalo() {
		int resultado = (int) ((Math.random() * 4));
		return PalosBarajaEspannola.values()[resultado].toString();
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("Baraja Española\n");

		for (int i = 0; i < super.numCartas; i++) {
			if (super.cartas[i].getNumber() <= 7)
				resultado.append(super.cartas[i].getNumber());
			else {
				if (super.cartas[i].getNumber() == 8)
					resultado.append("Sota");
				else if (super.cartas[i].getNumber() == 9)
					resultado.append("Caballo");
				else
					resultado.append("Rey");
			}
			resultado.append(" " + super.cartas[i].getPalo() + " \n");
		}
		return resultado.toString();

	}

}


