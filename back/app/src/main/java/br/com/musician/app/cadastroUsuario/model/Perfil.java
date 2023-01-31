package br.com.musician.app.cadastroUsuario.model;

public enum Perfil {
	CLIENTE("CLIENTE"), //
	ADMINISTRADOR("ADMINISTRADOR");

	private String perfil;

	private Perfil(String perfil) {
		this.perfil = perfil;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	};

}
