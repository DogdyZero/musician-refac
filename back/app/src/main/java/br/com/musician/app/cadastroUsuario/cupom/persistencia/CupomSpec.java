package br.com.musician.app.cadastroUsuario.cupom.persistencia;

import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;

import br.com.musician.app.aplicacao.QueryDynamicConstructor;
import br.com.musician.app.cadastroUsuario.cupom.controller.CupomFiltro;
import br.com.musician.app.cadastroUsuario.model.Cupom;

public class CupomSpec {

	private QueryDynamicConstructor<Cupom> queryDynamicConstructor;
	private CupomFiltro filtro;

	public CupomSpec(QueryDynamicConstructor<Cupom> queryDynamicConstructor, CupomFiltro filtro) {
		this.queryDynamicConstructor = queryDynamicConstructor;
		this.filtro = filtro;
	}

	private Specification<Cupom> id(UUID id) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}

	public Specification<Cupom> construirQuery() {
		if (filtro.getId() != null) {
			UUID uuid = UUID.fromString(this.filtro.getId());
			this.queryDynamicConstructor.add(id(uuid));
		}
		return this.queryDynamicConstructor.getAndSpecs();
	}


}
