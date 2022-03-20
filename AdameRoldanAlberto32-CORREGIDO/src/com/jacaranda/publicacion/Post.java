package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Post extends Publicacion {

	private int numeroLecturas;
	private String tema;

	public Post(String texto, Usuario usuario, String tema) {
		super(texto, usuario);
		this.numeroLecturas = 0;
		this.tema = tema;
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		
		if(texto.isEmpty())
			throw new PublicacionException("Post en blanco: ");
		super.texto = texto;
		

	}

	public boolean valorar(String texto) {
		boolean resultado = false;
		try {
			this.valoracion = Valoraciones.valueOf(texto.toUpperCase()).getValoracion();
			resultado = true;
			numeroLecturas++;
		} catch (Exception e) {
			System.out.println("Valoración incorrecta.");
		}
		return resultado;

	}
	
	@Override
	public String toString() {
		return "Post. \n" + super.toString() ;
	}
	
}
