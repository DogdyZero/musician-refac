package br.com.musician.app.cadastroUsuario.cupom.controller;

import org.springframework.stereotype.Service;

import br.com.musician.app.aplicacao.Dao;
import br.com.musician.app.aplicacao.interfaces.IEntidadeCommand;
import br.com.musician.app.aplicacao.interfaces.IEntidadeDto;
import br.com.musician.app.cadastroUsuario.cupom.persistencia.CupomDao;
import br.com.musician.app.cadastroUsuario.model.Cupom;

@Service
@Dao(CupomDao.class)
public class CupomCommand implements IEntidadeCommand<Cupom, CupomForm> {

	@Override
	public Cupom prepararParaSalvar(CupomForm form, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aposSalvar(Cupom entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IEntidadeDto toDto(Cupom entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
