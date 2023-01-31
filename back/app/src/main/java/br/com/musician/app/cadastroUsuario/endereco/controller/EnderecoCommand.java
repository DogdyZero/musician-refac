package br.com.musician.app.cadastroUsuario.endereco.controller;

import org.springframework.stereotype.Service;

import br.com.musician.app.aplicacao.Dao;
import br.com.musician.app.aplicacao.interfaces.IEntidadeCommand;
import br.com.musician.app.aplicacao.interfaces.IEntidadeDto;
import br.com.musician.app.cadastroUsuario.endereco.persistencia.EnderecoDao;
import br.com.musician.app.cadastroUsuario.model.Endereco;

@Service
@Dao(EnderecoDao.class)
public class EnderecoCommand implements IEntidadeCommand<Endereco, EnderecoForm>{

	@Override
	public Endereco prepararParaSalvar(EnderecoForm form, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aposSalvar(Endereco entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IEntidadeDto toDto(Endereco entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
