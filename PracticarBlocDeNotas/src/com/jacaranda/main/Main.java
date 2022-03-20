package com.jacaranda.main;


import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jacaranda.bloc.Bloc;
import com.jacaranda.bloc.BlocExecption;
import com.jacaranda.nota.Nota;
import com.jacaranda.nota.NotaAlarma;
import com.jacaranda.nota.NotaAlarmaException;
import com.jacaranda.nota.NotaException;

public class Main {

	public static void main(String[] args) throws BlocExecption, NotaAlarmaException, NotaException {
		// TODO Auto-generated method stub
		Nota n = new Nota("Primera");

		Bloc b = new Bloc("Bloc1");
		NotaAlarma na= new NotaAlarma("Prueba", LocalDateTime.now(), false);
		b.annadirNota("Hola");
		b.annadirNota("Segunda");
		System.out.println(b.ordenaBloc());
		b.ordenaBloc();//No he sabido crear el array Auxiliar en este ejemplo
		System.out.println("Nuevo "+b);
		
		b.annadirNota("Despertarme", true);// no se como poner para que me lea la fecha ah�, he tenido que quitar
												// el localDateTime
		b.annadirNota("Acostarme", 8);
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
