package br.com.musician.app.aplicacao.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacade {
	IEntidadeDto inserir(IEntidadeForm form);

	IEntidadeDto alterar(IEntidadeForm form, String id);

	Page<IEntidadeDto> pesquisar(IEntidadeFiltro<?> filtro, Pageable pageable);
}
