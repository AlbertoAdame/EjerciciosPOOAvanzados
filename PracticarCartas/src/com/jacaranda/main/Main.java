package com.jacaranda.main;

import java.util.Scanner;

import com.jacaranda.cartas.Baraja;
import com.jacaranda.cartas.Carta;


public class Main {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Baraja ba = new Baraja();
		ba.barajar();
		ba.ordenar();
		System.out.println(ba);
		ba.barajar();
		
		double jugador=0, banca=0;
		Carta c= null;
		boolean ganador=false;
		String pedir="";
		do {
			
			c= ba.getSiguiente();
			System.out.println(c);
			jugador+=c.getValor();
			System.out.println("El jugador tiene " +jugador);
			if (jugador==7.5)
				ganador=true;
			else if (jugador>7.5)
				pedir="No";
			else
				pedir = leerString("¿Quieres carta?");
		} while (pedir.equalsIgnoreCase("Si") || ganador==true);
			if (ganador==true)
				System.out.println("El jugador ha ganado");
			else if (jugador>7.5)
				System.out.println("Te has pasado, la banca ha gando");
			else {
				do {
					c=ba.getSiguiente();
					System.out.println(c);
					banca+=c.getValor();
					System.out.println("La banca tiene " +banca);
				} while (banca<jugador);
				if (banca==7.5 || banca==jugador)
					System.out.println("La banca ha gando");
				else 
					System.out.println("El jugador ha ganado");
				
			}
			
			

	}

	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}

	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
}
