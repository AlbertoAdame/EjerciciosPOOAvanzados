
public class Baraja {

	private int numCartas;
	private int siguiente;
	private Carta[] baraja;

	public Baraja() {
		super();
		this.numCartas = 40;
		this.siguiente = 0;
		this.baraja = new Carta[numCartas];

	}

	public void barajar() {
		int contador = 0;
		while (contador < numCartas) {
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
			siguiente = 0;
		}
	}

	public Carta getSiguiente() {
		Carta resultado = new Carta(baraja[siguiente].getNumber(), baraja[siguiente].getPalo());
		siguiente++;
		return resultado;
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder();
		for (int i = 0; i < numCartas; i++) {
			resultado.append(baraja[i].toString() + "\n");
		}
		return resultado.toString();
	}

	private String generarPalo() {
		String palo;
		int resultado = (int) (Math.random() * 4) + 1;
		if (resultado == 1)
			palo = "Oro";
		else if (resultado == 2)
			palo = "Copas";
		else if (resultado == 3)
			palo = "Bastos";
		else
			palo = "Espadas";
		return palo;
	}

	private int generarNumero() {
		int numero = (int) (Math.random() * 10) + 1;
		return numero;
	}

}
