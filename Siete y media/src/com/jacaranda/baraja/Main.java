package com.jacaranda.baraja;

import java.util.Scanner;

public class Main {
	
	public static Scanner teclado= new Scanner (System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int tipoBaraja= leerInt("Que baraja quieres (Española 0, Inglesa 1): ");
		
		if (tipoBaraja==0) {
			Baraja b = new BarajaEspannola();
			b.barajar();
			System.out.println(b);
			b.ordenar();
			System.out.println("ORDENADA");
			System.out.println(b);
			b.barajar();
			System.out.println("BARAJADA");
			System.out.println(b);

			
			double jugador=0, programa=0;
			
			Carta ca;
			
			char opcion='N';
			boolean perdido=false, magistral=false;
			
			do {
				System.out.println("Carta para ti");
				ca = b.getSiguiente();
				System.out.println(ca);
				jugador+=ca.getValor();
				if (jugador==7.5) {
					System.out.println("Tienes siete y media.");
					opcion='N';
					magistral=true;
				}
				
				else if (jugador>7.5) {
					System.out.println("Tienes " + jugador + " puntos.");
					opcion='N';
					perdido=true;
				}	
				else {
					System.out.println("Tienes " + jugador + " puntos.");
					opcion=leerChar("¿Quieres otra carta?");
					
				}
				
				
				
			}while (opcion!='N' && opcion!='n');
			
			if (!perdido && !magistral) {
				do {
					ca = b.getSiguiente();
					System.out.println(ca);
					programa+=ca.getValor();
					System.out.println("El programa tiene " + programa + " puntos.");				
					
				}while (programa<7);
			}
			
			if (magistral || (!perdido && (jugador==7.5 || programa>7.5 || jugador>programa))){
				System.out.println("El jugador ha ganado");
			}
			else System.out.println("El programa ha ganado");
		}
		
		else {
			
			Baraja b = new BarajaInglesa();
			b.barajar();
			System.out.println(b);
			b.ordenar();
			System.out.println("ORDENADA");
			System.out.println(b);
			b.barajar();
			System.out.println("BARAJADA");
			System.out.println(b);


			
			double jugador=0, programa=0;
			
			Carta ca;
			
			char opcion='N';
			boolean perdido=false, magistral=false;
			
			do {
				System.out.println("Carta para ti");
				ca = b.getSiguiente();
				System.out.println(ca);
				jugador+=ca.getValor();
				if (jugador==7.5) {
					System.out.println("Tienes siete y media.");
					opcion='N';
					magistral=true;
				}
				
				else if (jugador>7.5) {
					System.out.println("Tienes " + jugador + " puntos.");
					opcion='N';
					perdido=true;
				}	
				else {
					System.out.println("Tienes " + jugador + " puntos.");
					opcion=leerChar("¿Quieres otra carta?");
				}
				
				
				
			}while (opcion!='N' && opcion!='n');
			
			if (!perdido && !magistral) {
				do {
					ca = b.getSiguiente();
					System.out.println(ca);
					programa+=ca.getValor();
					System.out.println("El programa tiene " + programa + " puntos.");				
					
				}while (programa<7);
			}
			
			if (magistral || (!perdido && (jugador==7.5 || programa>7.5 || jugador>programa))){
				System.out.println("El jugador ha ganado");
			}
			else System.out.println("El programa ha ganado");
			
		}
		
		
		
		
	}
	
	public static char leerChar (String texto) {
		System.out.println(texto);
		return teclado.nextLine().charAt(0); 
	}
	
	public static int leerInt (String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine()); 
	}

}
