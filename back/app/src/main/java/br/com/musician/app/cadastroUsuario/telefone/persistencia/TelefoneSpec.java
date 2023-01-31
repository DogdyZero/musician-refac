package br.com.musician.app.cadastroUsuario.telefone.persistencia;

import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;

import br.com.musician.app.aplicacao.QueryDynamicConstructor;
import br.com.musician.app.cadastroUsuario.model.Telefone;
import br.com.musician.app.cadastroUsuario.telefone.controller.TelefoneFiltro;

public class TelefoneSpec {

	private QueryDynamicConstructor<Telefone> queryDynamicConstructor;
	private TelefoneFiltro filtro;

	public TelefoneSpec(QueryDynamicConstructor<Telefone> queryDynamicConstructor, TelefoneFiltro filtro) {
		this.queryDynamicConstructor = queryDynamicConstructor;
		this.filtro = filtro;
	}

	private Specification<Telefone> id(UUID id) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}

	public Specification<Telefone> construirQuery() {
		if (filtro.getId() != null) {
			UUID uuid = UUID.fromString(this.filtro.getId());
			this.queryDynamicConstructor.add(id(uuid));
		}
		return this.queryDynamicConstructor.getAndSpecs();
	}

}
