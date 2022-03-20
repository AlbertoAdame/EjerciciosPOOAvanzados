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
	
	public Publicacion(String texto, Usuario usuario) {
		super();
		this.texto = texto;
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

	public boolean valorar(String texto) {
		boolean resultado = false;
		try {
			this.valoracion = Valoraciones.valueOf(texto.toUpperCase()).getValoracion();
			resultado = true;
		} catch (Exception e) {
			System.out.println("Valoración incorrecta.");
		}
		return resultado;

	}

	
	public int getCodigo() {
		return codigo;
	}
	
	public String getLoginUsuario() {
		return this.usuario.getLogin();
		
	}

	@Override
	public String toString() {
		return "Publicacion: " + texto + "\n Realizado por: " + usuario.getLogin() + "\n Valoración=" + valoracion
				+ "\n Fecha de publicacion=" + fechaCreacion + "\n";
	}

	public int compareTo(Publicacion other) {
		int resultado =0;
		boolean orden=false;
		if (this.valoracion<other.valoracion)
			resultado = -1;
		if (resultado==0)
			orden = this.fechaCreacion.isBefore(other.getFechaCreacion());
		if(orden==true)
			resultado = -1;
		else
			resultado= 1;
		return resultado;
	}
	
	public boolean isAnterior(Publicacion other) {
		return this.fechaCreacion.isBefore(other.getFechaCreacion());
	}
	
	
	
	
	
}
