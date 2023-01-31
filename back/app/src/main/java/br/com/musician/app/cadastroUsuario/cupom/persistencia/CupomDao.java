package br.com.musician.app.cadastroUsuario.cupom.persistencia;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import br.com.musician.app.aplicacao.QueryDynamicConstructor;
import br.com.musician.app.aplicacao.interfaces.IDao;
import br.com.musician.app.aplicacao.interfaces.IEntidade;
import br.com.musician.app.cadastroUsuario.cupom.controller.CupomFiltro;
import br.com.musician.app.cadastroUsuario.model.Cupom;

public class CupomDao implements IDao<Cupom, CupomFiltro> {

	@Autowired
	private CupomRepository repository;
	private Cupom entidade;

	@Override
	public Cupom inserir() {
		return this.repository.save(entidade);
	}

	@Override
	public Cupom alterar() {
		return this.repository.save(entidade);
	}

	@Override
	public void setEntidade(IEntidade iEntidade) {
		this.entidade = (Cupom) iEntidade;
	}

	@Override
	public Collection<Cupom> pesquisa(CupomFiltro filtro) {
		return this.repository.findAll(getSpec(filtro));
	}

	@Override
	public Page<Cupom> pesquisaPaginada(CupomFiltro filtro) {
		return this.repository.findAll(getSpec(filtro), filtro.getPageable());
	}

	private Specification<Cupom> getSpec(CupomFiltro filtro) {
		CupomSpec spec = new CupomSpec(new QueryDynamicConstructor<Cupom>(), filtro);
		return spec.construirQuery();
	}

}
