package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Recomendacion extends Publicacion {

	protected int numeroEstrellas;

	public Recomendacion(String texto, Usuario usuario, int numeroEstrellas) throws PublicacionException {
		super(texto, usuario);
		setNumeroEstrellas(numeroEstrellas);
		;
	}

	private void setNumeroEstrellas(int numeroEstrellas) throws PublicacionException {// este método no estaba hecho, no
																						// tenía sentido que estuviera
																						// dentro del setTexto
		if ((numeroEstrellas < 1 || numeroEstrellas > 5))
			this.numeroEstrellas = numeroEstrellas;
		else
			throw new PublicacionException("Numero de estrellas invalido.");
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {// Faltaba poner el if para ver si "texto" es
																		// nulo

		if (texto == null)
			throw new PublicacionException("Texto nulo");

		if (texto.length() < 100 || texto.length() > 200)
			throw new PublicacionException("TamaÃ±o no vÃ¡lido.");

		super.texto = texto;

	}

	public int getNumeroEstrellas() {
		return numeroEstrellas;
	}

	@Override
	public String toString() {// aquí creé un StringBuilder por si no me daba tiempo de terminar el examen
		StringBuilder resultado = new StringBuilder("RecomendaciÃ³n.\n");
		resultado.append(super.toString() + "numeroEstrellas=" + numeroEstrellas + "\n");
		return resultado.toString();

	}

}
