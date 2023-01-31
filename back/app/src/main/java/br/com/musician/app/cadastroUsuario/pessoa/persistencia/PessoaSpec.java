package br.com.musician.app.cadastroUsuario.pessoa.persistencia;

import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;

import br.com.musician.app.aplicacao.QueryDynamicConstructor;
import br.com.musician.app.cadastroUsuario.model.Pessoa;
import br.com.musician.app.cadastroUsuario.pessoa.controller.PessoaFiltro;

public class PessoaSpec {

	private QueryDynamicConstructor<Pessoa> queryDynamicConstructor;
	private PessoaFiltro filtro;

	public PessoaSpec(QueryDynamicConstructor<Pessoa> queryDynamicConstructor, PessoaFiltro filtro) {
		this.queryDynamicConstructor = queryDynamicConstructor;
		this.filtro = filtro;
	}
	
	private Specification<Pessoa> id(UUID id) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}

	public Specification<Pessoa> construirQuery() {
		if (filtro.getId() != null) {
			UUID uuid = UUID.fromString(this.filtro.getId());
			this.queryDynamicConstructor.add(id(uuid));
		}
		return this.queryDynamicConstructor.getAndSpecs();
	}

}
