package br.com.musician.app.cadastroUsuario.pessoa.controller;

import org.springframework.stereotype.Service;

import br.com.musician.app.aplicacao.Dao;
import br.com.musician.app.aplicacao.interfaces.IEntidadeCommand;
import br.com.musician.app.aplicacao.interfaces.IEntidadeDto;
import br.com.musician.app.cadastroUsuario.model.Pessoa;
import br.com.musician.app.cadastroUsuario.pessoa.persistencia.PessoaDao;

@Service
@Dao(PessoaDao.class)
public class PessoaCommand implements IEntidadeCommand<Pessoa, PessoaForm>{

	@Override
	public Pessoa prepararParaSalvar(PessoaForm form, String id) {
		return null;
	}

	@Override
	public void aposSalvar(Pessoa entidade) {
		
	}

	@Override
	public IEntidadeDto toDto(Pessoa entidade) {
		return null;
	}

}

