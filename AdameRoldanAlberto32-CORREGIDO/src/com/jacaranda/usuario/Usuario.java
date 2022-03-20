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

	public boolean setPass(String pass, String oldPass) {//fallo en el pass, que es this.pass
		boolean resultado = false;
		if (pass.equals(oldPass)) {
			this.pass = pass;
			resultado = true;
		}
		return resultado;
	}
	
	public boolean checkPass(String contrasenia) {
		return this.pass.equals(contrasenia);
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
