package br.com.musician.app.cadastroUsuario.pessoa.persistencia;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import br.com.musician.app.aplicacao.QueryDynamicConstructor;
import br.com.musician.app.aplicacao.interfaces.IDao;
import br.com.musician.app.aplicacao.interfaces.IEntidade;
import br.com.musician.app.cadastroUsuario.model.Pessoa;
import br.com.musician.app.cadastroUsuario.pessoa.controller.PessoaFiltro;

@Repository
public class PessoaDao implements IDao<Pessoa, PessoaFiltro> {

	@Autowired
	private PessoaRepository repository;
	private Pessoa entidade;

	@Override
	public Pessoa inserir() {
		return this.repository.save(entidade);
	}

	@Override
	public Pessoa alterar() {
		return this.repository.save(entidade);
	}

	@Override
	public void setEntidade(IEntidade iEntidade) {
		this.entidade = (Pessoa) iEntidade;
	}

	@Override
	public Collection<Pessoa> pesquisa(PessoaFiltro filtro) {
		return this.repository.findAll(getSpec(filtro));
	}

	@Override
	public Page<Pessoa> pesquisaPaginada(PessoaFiltro filtro) {
		return this.repository.findAll(getSpec(filtro), filtro.getPageable());
	}

	private Specification<Pessoa> getSpec(PessoaFiltro filtro) {
		PessoaSpec spec = new PessoaSpec(new QueryDynamicConstructor<Pessoa>(), filtro);
		return spec.construirQuery();
	}

}
