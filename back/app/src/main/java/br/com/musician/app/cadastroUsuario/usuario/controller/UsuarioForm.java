package br.com.musician.app.cadastroUsuario.usuario.controller;

import br.com.musician.app.aplicacao.Command;
import br.com.musician.app.aplicacao.interfaces.IEntidadeForm;
import jakarta.validation.constraints.NotBlank;

@Command(UsuarioCommand.class)
public class UsuarioForm implements IEntidadeForm {

	@NotBlank(message = "{login.notempty}")
	private String login;
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
