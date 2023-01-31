package br.com.musician.app.cadastroUsuario.endereco.controller;

import org.springframework.stereotype.Service;

import br.com.musician.app.aplicacao.interfaces.IDefaultCommandHandle;
import br.com.musician.app.cadastroUsuario.model.Endereco;

@Service
public class EnderecoHandle implements IDefaultCommandHandle<Endereco, EnderecoForm> {

	@Override
	public Endereco add(EnderecoForm form) {
		return null;
	}

	@Override
	public Endereco update(EnderecoForm form, String id) {
		return null;
	}

}
