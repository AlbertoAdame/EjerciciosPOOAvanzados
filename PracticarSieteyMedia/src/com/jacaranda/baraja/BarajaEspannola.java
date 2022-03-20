package com.jacaranda.baraja;

public class BarajaEspannola extends Baraja {

	private static final int CARTAS_ESPANNOLAS = 40;

	public BarajaEspannola() {
		super(CARTAS_ESPANNOLAS);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String generarPalo() {
		int numero = (int) (Math.random() * 4) ;
		return PalosBarajaEspannola.values()[numero].toString();
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder();
		for (int i = 0; i < super.numCartas; i++) {
			if (super.cartas[i].getNumber() <= 7)
				resultado.append(cartas[i].getNumber());
			else {
				if (super.cartas[i].getNumber() == 8)
					resultado.append("Sota");
				else if (super.cartas[i].getNumber() == 9)
					resultado.append("Caballo");
				else if (super.cartas[i].getNumber() == 10)
					resultado.append("Rey");

			}
			resultado.append(" " + super.cartas[i].getPalo() + "\n");

		}
		return resultado.toString();

	}

}
