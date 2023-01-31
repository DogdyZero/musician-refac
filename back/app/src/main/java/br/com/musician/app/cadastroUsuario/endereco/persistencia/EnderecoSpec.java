package br.com.musician.app.cadastroUsuario.endereco.persistencia;

import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;

import br.com.musician.app.aplicacao.QueryDynamicConstructor;
import br.com.musician.app.cadastroUsuario.endereco.controller.EnderecoFiltro;
import br.com.musician.app.cadastroUsuario.model.Endereco;

public class EnderecoSpec {

	private QueryDynamicConstructor<Endereco> queryDynamicConstructor;
	private EnderecoFiltro filtro;

	public EnderecoSpec(QueryDynamicConstructor<Endereco> queryDynamicConstructor, EnderecoFiltro filtro) {
		this.queryDynamicConstructor = queryDynamicConstructor;
		this.filtro = filtro;
	}

	private Specification<Endereco> id(UUID id) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}

	public Specification<Endereco> construirQuery() {
		if (filtro.getId() != null) {
			UUID uuid = UUID.fromString(this.filtro.getId());
			this.queryDynamicConstructor.add(id(uuid));
		}
		return this.queryDynamicConstructor.getAndSpecs();
	}

}
