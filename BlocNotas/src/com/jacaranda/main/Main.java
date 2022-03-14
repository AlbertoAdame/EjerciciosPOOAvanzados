package com.jacaranda.main;

import java.util.Scanner;

import com.jacaranda.blocNotas.Bloc;
import com.jacaranda.blocNotas.BlocException;
import com.jacaranda.nota.Nota;
import com.jacaranda.nota.NotaAlarma;
import com.jacaranda.nota.NotaAlarmaException;
import com.jacaranda.nota.NotaException;

public class Main {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws BlocException, NotaAlarmaException, NotaException {
		// TODO Auto-generated method stub

		Nota n = new Nota("Primera");
		System.out.println(n);
		Bloc b = new Bloc("Bloc1");
		NotaAlarma na= new NotaAlarma("Prueba", false);
		b.anadirNota("Hola");
		b.anadirNota("Segunda");
//		b.ordenaBloc();//No he sabido crear el array Auxiliar en este ejemplo
		System.out.println(b);
		b.anadirNotaAlarma("Despertarme", true);// no se como poner para que me lea la fecha ahí, he tenido que quitar
												// el localDateTime
		b.anadirNotaAlarma("Acostarme", 8);
		System.out.println(b);
		System.out.println(n.isEmpty());
		System.out.println(n.isCreadoAnterior(n));
		System.out.println(n.isModificado());
		System.out.println(n.isModificadoAnterior(n));
		System.out.println(na.isActivado());
		na.activar();
		System.out.println(na.isActivado());
		na.desactivar();
	}

}
