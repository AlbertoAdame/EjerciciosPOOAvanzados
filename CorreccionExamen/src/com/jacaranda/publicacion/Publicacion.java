package com.jacaranda.publicacion;

import java.time.LocalDateTime;
import java.util.Objects;

import com.jacaranda.usuario.Usuario;

public abstract class Publicacion implements Comparable<Publicacion>, Valorable {
	protected String texto;
	private LocalDateTime fechaCreacion;
	protected int valoracion;
	private int codigo;
	private static int codigoSiguiente=1;
	private Usuario usuario;
	
	public Publicacion(String texto, Usuario usuario) throws PublicacionException {
		super();
		setTexto(texto);
		this.fechaCreacion = LocalDateTime.now();
		this.valoracion = 0;
		this.codigo = codigoSiguiente++;
		this.usuario= usuario;
	}

	protected String getTexto() {
		return texto;
	}

	protected abstract void setTexto(String texto) throws PublicacionException;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacion other = (Publicacion) obj;
		return Objects.equals(texto, other.texto);
	}
	

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	
	public int getValoracion() {
		return valoracion;
	}

	public boolean valorar(String texto) throws PublicacionException {
		boolean resultado = false;
		try {
			this.valoracion += Valoraciones.valueOf(texto.toUpperCase()).getValoracion();//se me pasó el signo "+"
			resultado = true;
		} catch (Exception e) {
			throw new PublicacionException("ValoraciÃ³n incorrecta.");
		}
		return resultado;

	}

	
	public int getCodigo() {
		return codigo;
	}
	
	public String getLoginUsuario() {//faltaba comprobar si es null
		String resultado = null;
		if (this.usuario!=null)
			resultado=this.usuario.getLogin();
		return resultado;
		
	}

	@Override
	public String toString() {
		return "Publicacion: " + texto + "\nRealizado por: " + usuario.getLogin() + "\nValoraciÃ³n=" + valoracion
				+ "\nFecha de publicacion=" + fechaCreacion + "\n";//quitaremos el espacio detrás del "\n" para que quede más limpio
	}

	public int compareTo(Publicacion other) {//este método estaba mal, era mucho más sencillo de lo que lo planteé
		int resultado=-1;
		if (other != null)
				resultado= this.valoracion - other.valoracion;
		if(resultado==0)
			resultado=this.fechaCreacion.compareTo(other.fechaCreacion);
		return resultado;
	}
	
	public boolean isAnterior(Publicacion other) {//faltaba comprobar si es null
		boolean resultado= false;
		if(other != null && this.fechaCreacion.isBefore(other.getFechaCreacion()))
			resultado = true;
		return resultado;
	}
	
	
	
	
	
}
