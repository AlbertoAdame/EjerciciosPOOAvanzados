package com.jacaranda.main;

import java.util.Scanner;

public class Main {
	
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

	}
	
	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}
	
	public static Integer leerInteger(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}

}
