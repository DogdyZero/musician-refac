package br.com.musician.app.cadastroUsuario.telefone.persistencia;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import br.com.musician.app.aplicacao.QueryDynamicConstructor;
import br.com.musician.app.aplicacao.interfaces.IDao;
import br.com.musician.app.aplicacao.interfaces.IEntidade;
import br.com.musician.app.cadastroUsuario.model.Telefone;
import br.com.musician.app.cadastroUsuario.telefone.controller.TelefoneFiltro;

@Repository
public class TelefoneDao implements IDao<Telefone, TelefoneFiltro> {

	@Autowired
	private TelefoneRepository repository;
	private Telefone entidade;

	@Override
	public Telefone inserir() {
		return this.repository.save(entidade);
	}

	@Override
	public Telefone alterar() {
		return this.repository.save(entidade);
	}

	@Override
	public void setEntidade(IEntidade iEntidade) {
		this.entidade = (Telefone) iEntidade;
	}

	@Override
	public Collection<Telefone> pesquisa(TelefoneFiltro filtro) {
		return this.repository.findAll(getSpec(filtro));
	}

	@Override
	public Page<Telefone> pesquisaPaginada(TelefoneFiltro filtro) {
		return this.repository.findAll(getSpec(filtro), filtro.getPageable());
	}

	private Specification<Telefone> getSpec(TelefoneFiltro filtro) {
		TelefoneSpec spec = new TelefoneSpec(new QueryDynamicConstructor<Telefone>(), filtro);
		return spec.construirQuery();
	}

}

