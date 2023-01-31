package br.com.musician.app.cadastroUsuario.usuario.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.musician.app.aplicacao.Dao;
import br.com.musician.app.aplicacao.interfaces.IEntidadeDto;
import br.com.musician.app.aplicacao.interfaces.IEntidadeFiltro;
import br.com.musician.app.cadastroUsuario.model.Usuario;
import br.com.musician.app.cadastroUsuario.usuario.persistencia.UsuarioDao;

@Dao(UsuarioDao.class)
public class UsuarioFiltro implements IEntidadeFiltro<Usuario> {

	private String id;
	private String login;
	private Pageable pageable;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}

	public Pageable getPageable() {
		return pageable;
	}


	public Page<IEntidadeDto> toDto(Page<Usuario> collection) {
		return collection.map(item -> new UsuarioDtoPadrao(item));
	}

}
