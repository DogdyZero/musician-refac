package br.com.musician.app.cadastroUsuario.cartao.controller;

import org.springframework.stereotype.Service;

import br.com.musician.app.aplicacao.interfaces.IDefaultCommandHandle;
import br.com.musician.app.cadastroUsuario.model.Cartao;

@Service
public class CartaoHandle implements IDefaultCommandHandle<Cartao, CartaoForm> {

	@Override
	public Cartao add(CartaoForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cartao update(CartaoForm form, String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
