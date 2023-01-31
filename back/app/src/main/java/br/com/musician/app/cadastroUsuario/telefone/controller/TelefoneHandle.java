package br.com.musician.app.cadastroUsuario.telefone.controller;

import org.springframework.stereotype.Service;

import br.com.musician.app.aplicacao.interfaces.IDefaultCommandHandle;
import br.com.musician.app.cadastroUsuario.model.Telefone;

@Service
public class TelefoneHandle implements IDefaultCommandHandle<Telefone, TelefoneForm> {

	@Override
	public Telefone add(TelefoneForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Telefone update(TelefoneForm form, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
