package br.com.musician.app.cadastroUsuario.telefone.controller;

import br.com.musician.app.aplicacao.Command;
import br.com.musician.app.aplicacao.interfaces.IEntidadeCommand;
import br.com.musician.app.aplicacao.interfaces.IEntidadeDto;
import br.com.musician.app.cadastroUsuario.model.Telefone;

@Command(TelefoneCommand.class)
public class TelefoneCommand implements IEntidadeCommand<Telefone, TelefoneForm>  {

	@Override
	public Telefone prepararParaSalvar(TelefoneForm form, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aposSalvar(Telefone entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IEntidadeDto toDto(Telefone entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
