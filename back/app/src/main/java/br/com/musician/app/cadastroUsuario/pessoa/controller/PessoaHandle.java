package br.com.musician.app.cadastroUsuario.pessoa.controller;

import org.springframework.stereotype.Service;

import br.com.musician.app.aplicacao.interfaces.IDefaultCommandHandle;
import br.com.musician.app.cadastroUsuario.model.Pessoa;

@Service
public class PessoaHandle implements IDefaultCommandHandle<Pessoa, PessoaForm>  {

	@Override
	public Pessoa add(PessoaForm form) {
		return null;
	}

	@Override
	public Pessoa update(PessoaForm form, String id) {
		return null;
	}

}
