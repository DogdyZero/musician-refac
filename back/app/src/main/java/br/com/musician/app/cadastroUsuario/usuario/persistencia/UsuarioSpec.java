package br.com.musician.app.cadastroUsuario.usuario.persistencia;

import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;

import br.com.musician.app.aplicacao.QueryDynamicConstructor;
import br.com.musician.app.cadastroUsuario.model.Usuario;
import br.com.musician.app.cadastroUsuario.usuario.controller.UsuarioFiltro;

public class UsuarioSpec {

	private QueryDynamicConstructor<Usuario> queryDynamicConstructor;
	private UsuarioFiltro filtro;

	private Specification<Usuario> id(UUID id) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}

	private Specification<Usuario> login(String login) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("login"), login);
	}

	public UsuarioSpec(QueryDynamicConstructor<Usuario> queryDynamicConstructor, UsuarioFiltro filtro) {
		this.queryDynamicConstructor = queryDynamicConstructor;
		this.filtro = filtro;
	}

	public Specification<Usuario> construirQuery() {
		if (filtro.getId() != null) {
			UUID uuid = UUID.fromString(this.filtro.getId());
			this.queryDynamicConstructor.add(id(uuid));
		}
		if (filtro.getLogin() != null) {
			this.queryDynamicConstructor.add(login(this.filtro.getLogin()));
		}
		return this.queryDynamicConstructor.getAndSpecs();
	}

}
