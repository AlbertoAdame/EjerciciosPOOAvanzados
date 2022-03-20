package com.jacaranda.memoryStorage;

import com.jacaranda.publicacion.Post;
import com.jacaranda.publicacion.Publicacion;
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

	public void addUsuario(String login, String contra) throws MemoryStorageException {
			if(posicionUsuario(login)!=-1)
				throw new MemoryStorageException("Este usuario ya existe.");
			usuarios[numUsuariosActuales++] = new Usuario(login, contra);
	}
	
	public void addPublicacion(String texto, String login) throws MemoryStorageException {
		if(posicionUsuario(login)==-1)
			throw new MemoryStorageException("Este usuario no existe.");
		int posicion =posicionUsuario(login);
		publicaciones[numPublicacionesActuales++]= new Tweet(texto,  usuarios[posicion]);
	}
	
	public void addPublicacion(String texto, String login, String tema) throws MemoryStorageException {
		if(posicionUsuario(login)==-1)
			throw new MemoryStorageException("Este usuario no existe.");
		int posicion =posicionUsuario(login);
		publicaciones[numPublicacionesActuales++]= new Post(texto, usuarios[posicion], tema);
	}
	
	public void addPublicacion(String texto, String login, int estrellas) throws MemoryStorageException {
		if(posicionUsuario(login)==-1)
			throw new MemoryStorageException("Este usuario no existe.");
		int posicion =posicionUsuario(login);
		publicaciones[numPublicacionesActuales++]= new Recomendacion(texto, usuarios[posicion], estrellas);
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
			if(publicaciones[i] instanceof Tweet)
			resultado.append(publicaciones[i] + " \n");
		}
		return resultado.toString();
	}
	
	public String mostrarPosts() {
		
		
		StringBuilder resultado = new StringBuilder("Lista publicaciones \n");

		for (int i = 0; i < numPublicacionesActuales; i++) {
			if(publicaciones[i] instanceof Post)
				resultado.append(publicaciones[i] + " \n");
			
		}
		return resultado.toString();
	}
	
	public String mostrarRecomendacion() {
		StringBuilder resultado = new StringBuilder("Lista publicaciones \n");

		for (int i = 0; i < numPublicacionesActuales; i++) {
			if(publicaciones[i] instanceof Recomendacion)
			resultado.append(publicaciones[i] + " \n");
		}
		return resultado.toString();
	}
	
	
}
