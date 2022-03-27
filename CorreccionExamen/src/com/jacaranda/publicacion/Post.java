package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Post extends Publicacion {

	private int numeroLecturas;
	private String tema;

	public Post(String texto, Usuario usuario, String tema) throws PublicacionException {
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

	public boolean valorar(String texto) throws PublicacionException {//en "Valoraciones.valueOf" le he puesto un parentesis más, aunque no sé si cambia algo, y el más
		boolean resultado = false;
		try {
			resultado =super.valorar(texto);//En este caso si podremos usar el del padre pq no hay que modificar nada en su funcionamiento.
			
		} catch (Exception e) {
			throw new PublicacionException("ValoraciÃ³n incorrecta.");
		}
		return resultado;

	}
	
	@Override
	public String toString() {
		return "Post. \n" + super.toString() ;
	}
	
}
