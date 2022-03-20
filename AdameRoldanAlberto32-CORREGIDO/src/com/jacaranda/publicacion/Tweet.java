package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Tweet extends Publicacion {
	

	public Tweet(String texto, Usuario usuario) {
		super(texto, usuario);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	protected void setTexto(String texto) throws PublicacionException {
		
			if(texto.length()<0 || texto.length()>50)
				throw new PublicacionException("Tweet demasiado largo.");
				super.texto=texto;
		 
		

	}
	
	
	public boolean valorar(String texto) {
		boolean resultado = false;
		try {
			this.valoracion = 2*(Valoraciones.valueOf(texto.toUpperCase()).getValoracion());
			resultado = true;
		} catch (Exception e) {
			System.out.println("Valoración incorrecta.");
		}
		return resultado;

	}



	@Override
	public String toString() {
		return "Tweet. \n" + super.toString() ;
	}
	
	

}
