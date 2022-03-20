package boletin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ED1T2P {
	public static void main(String[] args) throws IOException {
		int numero;
		double resultado;

		BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));// Colocamos un breakpoint al
																						// principio para ver donde
																						// fallaba
		System.out.println("Dame un número:");
		numero = Integer.parseInt(lectura.readLine());
		resultado = funcionMagica(numero);// Después uno en la función en la cual da fallo, para entrar en ella
		System.out.println("El resultado obtenido es " + resultado);
	}

	public static double funcionMagica(int a) {
		double r;
		r = a / (((((((a * 2.0) * 5.0) * 3.0) / 2.0) / 5.0) / 3.0));// Con los breakpoints llegamos hasta este punto.Lo
																	// que hemos hecho ha sido quitarle el menos uno
																	// final.
		return r;
	}
}
