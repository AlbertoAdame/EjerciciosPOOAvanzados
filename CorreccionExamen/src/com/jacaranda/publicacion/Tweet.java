package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Tweet extends Publicacion {

	public Tweet(String texto, Usuario usuario) throws PublicacionException {
		super(texto, usuario);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {//Faltaba comprobar el null
		
		if (texto==null)
			throw new PublicacionException("El texto es nulo.");
		
		if (texto.length() < 0 || texto.length() > 50)
			throw new PublicacionException("Tweet demasiado largo.");
		super.texto = texto;

	}

	public boolean valorar(String texto) throws PublicacionException {//aqu� faltaba sumarle la valoraci�n
		boolean resultado = false;
		try {
			this.valoracion =this.getValoracion()+  2 * (Valoraciones.valueOf(texto.toUpperCase()).getValoracion());//Aqu� no podremos usar el del padre, pq tenemos que multiplicarlo por 2
			resultado = true;
		} catch (Exception e) {
			throw new PublicacionException("Valoración incorrecta.");
		}
		return resultado;

	}

	@Override
	public String toString() {
		return "Tweet. \n" + super.toString();
	}

}
