package br.com.musician.app.cadastroUsuario.telefone.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.musician.app.aplicacao.Dao;
import br.com.musician.app.aplicacao.interfaces.IEntidadeDto;
import br.com.musician.app.aplicacao.interfaces.IEntidadeFiltro;
import br.com.musician.app.cadastroUsuario.model.Telefone;
import br.com.musician.app.cadastroUsuario.telefone.persistencia.TelefoneDao;

@Dao(TelefoneDao.class)
public class TelefoneFiltro implements IEntidadeFiltro<Telefone> {

	private String id;
	private Pageable pageable;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setPageable(Pageable pageable) {
		this.pageable = pageable;

	}

	@Override
	public Pageable getPageable() {
		return this.pageable;
	}

	@Override
	public Page<IEntidadeDto> toDto(Page<Telefone> collection) {
		return null;
	}

}
