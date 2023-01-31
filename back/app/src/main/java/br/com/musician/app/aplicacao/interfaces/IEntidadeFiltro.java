package br.com.musician.app.aplicacao.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEntidadeFiltro<Entidade extends IEntidade> {
	
	void setPageable(Pageable pageable);
	
	Pageable getPageable();

	Page<IEntidadeDto> toDto(Page<Entidade> collection);
}
