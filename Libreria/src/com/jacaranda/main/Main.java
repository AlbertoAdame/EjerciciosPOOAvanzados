package com.jacaranda.main;

import java.util.Scanner;

import com.jacaranda.libro.Libro;
import com.jacaranda.libro.LibroDigital;
import com.jacaranda.libro.LibroDigitalException;
import com.jacaranda.libro.LibroException;
import com.jacaranda.libro.LibroPapel;

public class Main {
	public static Scanner teclado = new Scanner(System.in);
	public static int TOTAL_LIBROS = 6;
	public static Libro[] libros = new Libro[TOTAL_LIBROS];
	public static int contador= 0;

	public static void main(String[] args) throws LibroException {
		// TODO Auto-generated method stub
		
//		for (int i = 0; i < 6; i++) {
			String titulo = leerString("Dame el t�tulo del libro: ");
			String autor = leerString("Dame el nombre del autor: ");
			
			
			
//			if(i<=1) {
//				Libro l = new Libro(titulo, autor);
//				libros[i] = l;
//				contador++;
//			}
//				
//			
//			else if (i<=3) {
//
//				String editorial = leerString("Dame la editorial: ");
//				int peso = leerInt("Dame el peso: ");
//				double precio = leerDouble("Dame el precio: ");
//			
//				libros[i] = new LibroPapel(titulo, autor, editorial, peso, precio);
//				contador++;
//			}
//			
//			else {

				String editorial = leerString("Dame la editorial: ");
				double precio = leerDouble("Dame el precio: ");
				boolean creado = false;
				
				String formato = leerString("Dame el formato (EPUB, MOBI, PDF): ");	
				try {
					libros[0] = new LibroDigital(titulo, autor, editorial, precio, formato);
					contador++;
				
				} catch (LibroDigitalException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage()); 
				}

			

		
		
		for (int i = 0; i < contador; i++) {
			System.out.println(libros[i]);
			
		}
		
//		System.out.println(libros[0].masCaro(libros[1]));
//		System.out.println(libros[2].masCaro(libros[3]));
//		System.out.println(libros[4].masCaro(libros[5]));
//		
		
	}

	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	public static double leerDouble(String texto) {
		System.out.println(texto);
		return Double.parseDouble(teclado.nextLine());
	}

	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}

}
