package com.jacaranda.usuario;

import java.util.Objects;

public class Usuario {
	private String login;
	private String pass;

	public Usuario(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}

	public String getLogin() {
		return login;
	}

	public boolean setPass(String pass, String oldPass) {
		boolean resultado = false;
		if ( oldPass != null)//Falta la excepción para los nulos
			if (this.pass.equals(oldPass)) {
				this.pass = pass;//aquí se me pasó el this.
				resultado = true;
		}
		return resultado;
	}
	
	public boolean checkPass(String contrasenia) {//aqui falta la excepcion para los nulos aunque no la pidiera
		boolean resultado=false;
		if (contrasenia !=null && this.pass.equals(contrasenia))
			resultado = true;
		return resultado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(login);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(login, other.login);
	}

	
}
