package br.com.musician.app.spring.security;

import jakarta.validation.constraints.NotBlank;

public class LoginForm {
	@NotBlank
	private String login;

	@NotBlank
	private String senha;

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

}
