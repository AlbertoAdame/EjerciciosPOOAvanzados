package com.jacaranda.main;

import java.time.LocalDate;
import java.util.Scanner;

import com.jacaranda.alquiler.Coche;
import com.jacaranda.alquiler.Furgo;
import com.jacaranda.alquiler.MicroBus;
import com.jacaranda.alquiler.Vehiculo;
import com.jacaranda.alquiler.VehiculoException;

public class Main {
	public static Scanner teclado = new Scanner(System.in);
	public static int MAX_VEHICULOS = 10;
	public static int numVehiculos = 0;
	public static Vehiculo[] vehiculos = new Vehiculo[MAX_VEHICULOS];

	public static void main(String[] args) throws VehiculoException {
		// TODO Auto-generated method stub

//		try {
//			Vehiculo v = new Vehiculo("4856gpz", "Baja", null);
//			Coche c= new Coche("2020", "Baja", LocalDate.of(2022, 3, 15), "gasolina");
//			System.out.println(v);
//			v.setFechaSalida(LocalDate.of(2022, 3, 15));
//			System.out.println(v.getPrecio());
//			System.out.println(c.getPrecio());
//		} catch (VehiculoException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
		int programa = 0;
		do {
			menu();
			programa = leerInt("Que quieres hacer:");
			switch (programa) {
			case 1:
				Vehiculo v = null;
				boolean encontrado = false;
				if (numVehiculos < MAX_VEHICULOS) {
					String matricula = leerString("Dame la matrícula: ");
					String gama = leerString("Dame la gama del vehiculo(Baja, Media, Alta):");
					String fechaSalida = leerString("Dame la fecha de salia(YYYY-MM-DD):");

					v = new Vehiculo(matricula, gama, LocalDate.parse(fechaSalida));
					for (int i = 0; i < numVehiculos && !encontrado; i++) {
						if (vehiculos[i].equals(v)) {
							encontrado = true;
							System.out.println("Este vehiculo ya existe");
						}

					}
					if (!encontrado) {
						String tipo = leerString("Que tipo de vehiculo es(Coche, Furgoneta, Microbus): ");
						if (tipo.equalsIgnoreCase("coche")) {
							String carburante = leerString("Dame el tipo de carburante(gasolina, gasoil): ");

							Coche c = new Coche(matricula, gama, LocalDate.parse(fechaSalida), carburante);
							vehiculos[numVehiculos] = c;
							numVehiculos++;
						} else if (tipo.equalsIgnoreCase("furgoneta")) {
							double peso = leerDouble("Dame el peso máximo: ");

							Furgo f = new Furgo(matricula, gama, LocalDate.parse(fechaSalida), peso);
							vehiculos[numVehiculos] = f;
							numVehiculos++;
						}

						else if (tipo.equalsIgnoreCase("microbus")) {
							int plazas = leerInt("Dame el numero de plazas: ");

							MicroBus m = new MicroBus(matricula, gama, LocalDate.parse(fechaSalida), plazas);
							vehiculos[numVehiculos] = m;
							numVehiculos++;
						} else
							System.out.println("Este vehículo no existe");
					}

				}
				break;
			case 2:
				
				for (int i = 0; i < numVehiculos; i++) {
					System.out.println(vehiculos[i].getPrecio());
				}
				
				break;

			case 3:
				for (int i = 0; i < numVehiculos; i++) {
					System.out.println(vehiculos[i]);

				}
				break;

			}

		} while (programa != 4);

	}

	public static void menu() {
		System.out.println(
				"1.Alta de vehiculo \n" + "2.Cálculo de precio de alquiler. \n" + "3.Mostrar vehiculos.\n" + "4.salir");
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
