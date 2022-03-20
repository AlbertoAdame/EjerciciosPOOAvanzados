package boletin;

import java.util.Random;

public class ED1T1P {
	static Random rnd = new Random();

	public static void main(String[] args) {
		int veces;
		int contador = 0;
		veces = rnd.nextInt(100) + 1;// hemos colado el breakpoint al principio para controlar los valores en cada
										// momento
		for (int i = 0; i < veces; i++) {
//		contador = 0; deberemos quitar este contador que siempre lo pone a 0
			System.out.println(rnd.nextInt(50));
			contador++;
		}
		System.out.println("Se han generado " + contador + " números aleatorios");
	}
}
