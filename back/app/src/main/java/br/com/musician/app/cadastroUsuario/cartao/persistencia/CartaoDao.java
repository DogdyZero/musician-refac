package br.com.musician.app.cadastroUsuario.cartao.persistencia;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import br.com.musician.app.aplicacao.QueryDynamicConstructor;
import br.com.musician.app.aplicacao.interfaces.IDao;
import br.com.musician.app.aplicacao.interfaces.IEntidade;
import br.com.musician.app.cadastroUsuario.cartao.controller.CartaoFiltro;
import br.com.musician.app.cadastroUsuario.model.Cartao;

public class CartaoDao implements IDao<Cartao, CartaoFiltro>{

	@Autowired
	private CartaoRepository repository;
	private Cartao entidade;

	@Override
	public Cartao inserir() {
		return this.repository.save(entidade);
	}

	@Override
	public Cartao alterar() {
		return this.repository.save(entidade);
	}

	@Override
	public void setEntidade(IEntidade iEntidade) {
		this.entidade = (Cartao) iEntidade;
	}

	@Override
	public Collection<Cartao> pesquisa(CartaoFiltro filtro) {
		return this.repository.findAll(getSpec(filtro));
	}

	@Override
	public Page<Cartao> pesquisaPaginada(CartaoFiltro filtro) {
		return this.repository.findAll(getSpec(filtro), filtro.getPageable());
	}

	private Specification<Cartao> getSpec(CartaoFiltro filtro) {
		CartaoSpec spec = new CartaoSpec(new QueryDynamicConstructor<Cartao>(), filtro);
		return spec.construirQuery();
	}

}
