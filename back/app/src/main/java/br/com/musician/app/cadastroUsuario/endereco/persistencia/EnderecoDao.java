package br.com.musician.app.cadastroUsuario.endereco.persistencia;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import br.com.musician.app.aplicacao.QueryDynamicConstructor;
import br.com.musician.app.aplicacao.interfaces.IDao;
import br.com.musician.app.aplicacao.interfaces.IEntidade;
import br.com.musician.app.cadastroUsuario.endereco.controller.EnderecoFiltro;
import br.com.musician.app.cadastroUsuario.model.Endereco;

@Repository
public class EnderecoDao implements IDao<Endereco, EnderecoFiltro> {

	@Autowired
	private EnderecoRepository repository;
	private Endereco entidade;

	@Override
	public Endereco inserir() {
		return this.repository.save(entidade);
	}

	@Override
	public Endereco alterar() {
		return this.repository.save(entidade);
	}

	@Override
	public void setEntidade(IEntidade iEntidade) {
		this.entidade = (Endereco) iEntidade;
	}

	@Override
	public Collection<Endereco> pesquisa(EnderecoFiltro filtro) {
		return this.repository.findAll(getSpec(filtro));
	}

	@Override
	public Page<Endereco> pesquisaPaginada(EnderecoFiltro filtro) {
		return this.repository.findAll(getSpec(filtro), filtro.getPageable());
	}

	private Specification<Endereco> getSpec(EnderecoFiltro filtro) {
		EnderecoSpec spec = new EnderecoSpec(new QueryDynamicConstructor<Endereco>(), filtro);
		return spec.construirQuery();
	}
}
