package br.com.musician.app.aplicacao.interfaces;

import java.util.Collection;

import org.springframework.data.domain.Page;

public interface IDao<Entidade extends IEntidade, Filtro extends IEntidadeFiltro> {

	Entidade inserir();

	Entidade alterar();

	void setEntidade(IEntidade iEntidade);
	
	Collection<Entidade> pesquisa(Filtro filtro);
	
	Page<Entidade> pesquisaPaginada(Filtro filtro);

}
