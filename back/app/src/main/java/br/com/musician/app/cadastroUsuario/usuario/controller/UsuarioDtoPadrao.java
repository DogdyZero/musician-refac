package br.com.musician.app.cadastroUsuario.usuario.controller;

import br.com.musician.app.aplicacao.interfaces.IEntidadeDto;
import br.com.musician.app.cadastroUsuario.model.Usuario;

public class UsuarioDtoPadrao implements IEntidadeDto {

	private String login;
	private String perfil;
	private String status;

	public UsuarioDtoPadrao(Usuario usuario) {
		this.login = usuario.getLogin();
		this.perfil = usuario.getPerfil() != null ? usuario.getPerfil().name().toLowerCase() : null;
		this.status = usuario.getStatus() != null ? usuario.getStatus().name().toLowerCase(): null;
	}

	public String getLogin() {
		return login;
	}

	public String getPerfil() {
		return perfil;
	}

	public String getStatus() {
		return status;
	}


}
