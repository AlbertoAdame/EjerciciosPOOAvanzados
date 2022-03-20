package boletin;

public class ED1T3P {
	public static void main(String[] args) {
		int i;
		i = 0;
		while (i < 100) {// Colocamos el breackpoint al principio del programa
			if (i % 2 == 0) {
				System.out.println("Par");
				i++;
			} else {
				System.out.println("Impar");
				i++;// Cambiamos el --, por ++, para que vaya incrementando
			}
		}
	}
}
