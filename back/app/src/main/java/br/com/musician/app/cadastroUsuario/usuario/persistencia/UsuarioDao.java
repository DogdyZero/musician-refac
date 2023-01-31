package br.com.musician.app.cadastroUsuario.usuario.persistencia;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import br.com.musician.app.aplicacao.QueryDynamicConstructor;
import br.com.musician.app.aplicacao.interfaces.IDao;
import br.com.musician.app.aplicacao.interfaces.IEntidade;
import br.com.musician.app.cadastroUsuario.model.Usuario;
import br.com.musician.app.cadastroUsuario.usuario.controller.UsuarioFiltro;

@Repository
public class UsuarioDao implements IDao<Usuario, UsuarioFiltro> {

	@Autowired
	private UsuarioRepository repository;

	private Usuario entidade;

	@Override
	public void setEntidade(IEntidade iEntidade) {
		this.entidade = (Usuario) iEntidade;
	}

	@Override
	public Usuario inserir() {
		return repository.save(entidade);
	}

	@Override
	public Usuario alterar() {
		return repository.save(entidade);
	}

	@Override
	public Collection<Usuario> pesquisa(UsuarioFiltro filtro) {
		return this.repository.findAll(getSpec(filtro));
	}

	@Override
	public Page<Usuario> pesquisaPaginada(UsuarioFiltro filtro) {
		return this.repository.findAll(getSpec(filtro), filtro.getPageable());
	}

	private Specification<Usuario> getSpec(UsuarioFiltro filtro) {
		UsuarioSpec spec = new UsuarioSpec(new QueryDynamicConstructor<Usuario>(), filtro);
		return spec.construirQuery();
	}

}
