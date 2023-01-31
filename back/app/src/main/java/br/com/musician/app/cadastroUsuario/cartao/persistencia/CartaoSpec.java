package br.com.musician.app.cadastroUsuario.cartao.persistencia;

import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;

import br.com.musician.app.aplicacao.QueryDynamicConstructor;
import br.com.musician.app.cadastroUsuario.cartao.controller.CartaoFiltro;
import br.com.musician.app.cadastroUsuario.model.Cartao;

public class CartaoSpec {

	private QueryDynamicConstructor<Cartao> queryDynamicConstructor;
	private CartaoFiltro filtro;

	public CartaoSpec(QueryDynamicConstructor<Cartao> queryDynamicConstructor, CartaoFiltro filtro) {
		this.queryDynamicConstructor = queryDynamicConstructor;
		this.filtro = filtro;
	}

	private Specification<Cartao> id(UUID id) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}

	public Specification<Cartao> construirQuery() {
		if (filtro.getId() != null) {
			UUID uuid = UUID.fromString(this.filtro.getId());
			this.queryDynamicConstructor.add(id(uuid));
		}
		return this.queryDynamicConstructor.getAndSpecs();
	}

}
