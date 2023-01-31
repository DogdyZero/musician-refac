package br.com.musician.app.aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.musician.app.aplicacao.interfaces.IDao;
import br.com.musician.app.aplicacao.interfaces.IEntidade;
import br.com.musician.app.aplicacao.interfaces.IEntidadeCommand;
import br.com.musician.app.aplicacao.interfaces.IEntidadeDto;
import br.com.musician.app.aplicacao.interfaces.IEntidadeFiltro;
import br.com.musician.app.aplicacao.interfaces.IEntidadeForm;
import br.com.musician.app.aplicacao.interfaces.IFacade;

@Service
@SuppressWarnings("all")
public class Facade implements IFacade {

	@Autowired
	private SpringFactoryBean factory;

	@Override
	public IEntidadeDto inserir(IEntidadeForm form) {
		IEntidadeCommand command = (IEntidadeCommand) factory.getEntidade(form);
		IDao dao = (IDao) factory.getEntidade(command);
		IEntidade entidade = command.prepararParaSalvar(form, null);
		dao.setEntidade(entidade);
		IEntidade entidadeInserida = dao.inserir();
		return posTransacao(command, entidadeInserida);
	}

	@Override
	public IEntidadeDto alterar(IEntidadeForm form, String id) {
		IEntidadeCommand command = (IEntidadeCommand) factory.getEntidade(form);
		IDao dao = (IDao) factory.getEntidade(command);
		IEntidade entidade = command.prepararParaSalvar(form, id);
		dao.setEntidade(entidade);
		IEntidade entidadeInserida = dao.alterar();
		return posTransacao(command, entidadeInserida);
	}
	
	private IEntidadeDto posTransacao(IEntidadeCommand command, IEntidade entidadeInserida) {
		command.aposSalvar(entidadeInserida);
		return command.toDto(entidadeInserida);
	}

	@Override
	public Page<IEntidadeDto> pesquisar(IEntidadeFiltro filtro, Pageable pageable) {
		filtro.setPageable(pageable);
		IDao dao = (IDao) factory.getEntidade(filtro);
		Page colecao = dao.pesquisaPaginada(filtro);
		return filtro.toDto(colecao);
	}

}
