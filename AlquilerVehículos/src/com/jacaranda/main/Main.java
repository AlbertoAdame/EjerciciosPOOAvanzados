package com.jacaranda.main;

import java.time.LocalDate;

import com.jacaranda.Vehiculo;
import com.jacaranda.VehiculoException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Vehiculo v = new Vehiculo("4856gpz", "Baja", null);
			System.out.println(v);
			v.setFechaSalida(LocalDate.of(2022, 3, 15));
			System.out.println(v.getPrecio());
		} catch (VehiculoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}

}
