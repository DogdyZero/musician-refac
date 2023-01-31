package br.com.musician.app.cadastroUsuario.cupom.controller;

import org.springframework.stereotype.Service;

import br.com.musician.app.aplicacao.interfaces.IDefaultCommandHandle;
import br.com.musician.app.cadastroUsuario.model.Cupom;

@Service
public class CupomHandle implements IDefaultCommandHandle<Cupom, CupomForm> {

	@Override
	public Cupom add(CupomForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cupom update(CupomForm form, String id) {
		// TODO Auto-generated method stub
		return null;
	}


}