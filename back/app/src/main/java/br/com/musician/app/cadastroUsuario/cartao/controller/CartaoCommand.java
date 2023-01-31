package br.com.musician.app.cadastroUsuario.cartao.controller;

import org.springframework.stereotype.Service;

import br.com.musician.app.aplicacao.Dao;
import br.com.musician.app.aplicacao.interfaces.IEntidadeCommand;
import br.com.musician.app.aplicacao.interfaces.IEntidadeDto;
import br.com.musician.app.cadastroUsuario.cupom.persistencia.CupomDao;
import br.com.musician.app.cadastroUsuario.model.Cartao;

@Service
@Dao(CupomDao.class)
public class CartaoCommand implements IEntidadeCommand<Cartao, CartaoForm> {

	@Override
	public Cartao prepararParaSalvar(CartaoForm form, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aposSalvar(Cartao entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public IEntidadeDto toDto(Cartao entidade) {
		// TODO Auto-generated method stub
		return null;
	}
}
