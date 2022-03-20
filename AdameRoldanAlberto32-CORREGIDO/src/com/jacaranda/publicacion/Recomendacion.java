package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Recomendacion extends Publicacion {

	protected int numeroEstrellas;
	
	
	
	
	public Recomendacion(String texto, Usuario usuario, int numeroEstrellas) {
		super(texto, usuario);
		this.numeroEstrellas = numeroEstrellas;
	}

	


	@Override
	protected void setTexto(String texto) throws PublicacionException  {
		
			
			if((numeroEstrellas<1 || numeroEstrellas>5) )
				throw new PublicacionException("Numero de estrellas no válido.");
			
			
			else if(texto.length()<100 || texto.length()>200)
				throw new PublicacionException("Tamaño no válido.");
			
			super.texto=texto;
			
				 
		

	}


	public int getNumeroEstrellas() {
		return numeroEstrellas;
	}




	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("Recomendación. \n");		
		resultado.append(super.toString() + "numeroEstrellas=" + numeroEstrellas +"\n");
		return resultado.toString();
		
	}

	
	
}
