package com.jacaranda.memoryStorage;

import com.jacaranda.publicacion.Post;
import com.jacaranda.publicacion.Publicacion;
import com.jacaranda.publicacion.PublicacionException;
import com.jacaranda.publicacion.Recomendacion;
import com.jacaranda.publicacion.Tweet;
import com.jacaranda.usuario.Usuario;

public class MemoryStorage {

	private static final int NUM_MAXIMO_USUARIO = 15;
	private static final int NUM_MAXIMO_PUBLICACIONES = 50;
	private int numUsuariosActuales;
	private int numPublicacionesActuales;
	private Publicacion[] publicaciones;
	private Usuario[] usuarios;

	public MemoryStorage() {
		super();
		this.numUsuariosActuales = 0;
		this.numPublicacionesActuales = 0;
		this.publicaciones = new Publicacion[NUM_MAXIMO_PUBLICACIONES];
		this.usuarios = new Usuario[NUM_MAXIMO_USUARIO];
	}

	private int posicionUsuario(String nombre) {
		boolean encontrado = false;
		int posicion = -1;
		for (int i = 0; i < numUsuariosActuales && !encontrado; i++) {
			if (usuarios[i].getLogin().equals(nombre)) {
				encontrado = true;
				posicion = i;
			}
		}
		return posicion;
	}

//	public void addUsuario(String login, String contra) throws MemoryStorageException {//Este era mi addUsuario que estaría bien, pero vamos a poner el que había que hacer para el extra
//			if(posicionUsuario(login)!=-1)
//				throw new MemoryStorageException("Este usuario ya existe.");
//			usuarios[numUsuariosActuales++] = new Usuario(login, contra);
//	}

	public void addUsuario(String login, String pass) throws MemoryStorageException {
		if (posicionUsuario(login) != -1)
			throw new MemoryStorageException("Usuario repetido");

		if (this.numUsuariosActuales == NUM_MAXIMO_USUARIO) {
			for (int i = 0; i < this.numUsuariosActuales; i++) {
				this.usuarios[i - 1] = this.usuarios[i];
			}
			this.usuarios[this.numUsuariosActuales] = new Usuario(login, pass);
		} else {
			this.usuarios[this.numUsuariosActuales] = new Usuario(login, pass);
			this.numPublicacionesActuales++;
		}
	}

	public void addPublicacion(String texto, String login) throws MemoryStorageException {// deberemos poner el try, y
																							// sumarle un más al número
																							// de publicaciones
		if (posicionUsuario(login) == -1)
			throw new MemoryStorageException("Este usuario no existe.");
		int posicion = posicionUsuario(login);
		try {
			if (this.numPublicacionesActuales < NUM_MAXIMO_PUBLICACIONES) {
				publicaciones[numPublicacionesActuales++] = new Tweet(texto, usuarios[posicion]);
				this.numPublicacionesActuales++;
			}
		} catch (Exception e) {
			throw new MemoryStorageException(e.getLocalizedMessage());
		}

	}

	public void addPublicacion(String texto, String login, String tema) throws MemoryStorageException {// ponemos el
																										// try/catch
		if (posicionUsuario(login) == -1)
			throw new MemoryStorageException("Este usuario no existe.");
		int posicion = posicionUsuario(login);
		try {
			if (this.numPublicacionesActuales < NUM_MAXIMO_PUBLICACIONES) {
				publicaciones[numPublicacionesActuales++] = new Post(texto, usuarios[posicion], tema);
			}

		} catch (Exception e) {
			throw new MemoryStorageException(e.getLocalizedMessage());
		}

	}

	public void addPublicacion(String texto, String login, int estrellas)
			throws MemoryStorageException, PublicacionException {// pondremos el try/catch
		if (posicionUsuario(login) == -1)
			throw new MemoryStorageException("Este usuario no existe.");
		int posicion = posicionUsuario(login);
		try {
			if (this.numPublicacionesActuales < NUM_MAXIMO_PUBLICACIONES) {
				publicaciones[numPublicacionesActuales++] = new Recomendacion(texto, usuarios[posicion], estrellas);
			}
		} catch (Exception e) {
			throw new MemoryStorageException(e.getLocalizedMessage());
		}

	}

	public String mostrarListaPublicaciones() {

		StringBuilder resultado = new StringBuilder("Lista publicaciones \n");

		for (int i = 0; i < numPublicacionesActuales; i++) {
			resultado.append(publicaciones[i] + " \n");
		}
		return resultado.toString();

	}

	public String mostrarTweets() {
		StringBuilder resultado = new StringBuilder("Lista publicaciones \n");

		for (int i = 0; i < numPublicacionesActuales; i++) {
			if (publicaciones[i] instanceof Tweet)
				resultado.append(publicaciones[i] + " \n");
		}
		return resultado.toString();
	}

	public String mostrarPosts() {

		StringBuilder resultado = new StringBuilder("Lista publicaciones \n");

		for (int i = 0; i < numPublicacionesActuales; i++) {
			if (publicaciones[i] instanceof Post)
				resultado.append(publicaciones[i] + " \n");

		}
		return resultado.toString();
	}

	public String mostrarRecomendacion() {
		StringBuilder resultado = new StringBuilder("Lista publicaciones \n");

		for (int i = 0; i < numPublicacionesActuales; i++) {
			if (publicaciones[i] instanceof Recomendacion)
				resultado.append(publicaciones[i] + " \n");
		}
		return resultado.toString();
	}

}
