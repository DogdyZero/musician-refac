package br.com.musician.app.cadastroUsuario.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musician.app.aplicacao.Dao;
import br.com.musician.app.aplicacao.interfaces.IEntidadeCommand;
import br.com.musician.app.aplicacao.interfaces.IEntidadeDto;
import br.com.musician.app.cadastroUsuario.model.Usuario;
import br.com.musician.app.cadastroUsuario.usuario.persistencia.UsuarioDao;

@Service
@Dao(UsuarioDao.class)
public class UsuarioCommand implements IEntidadeCommand<Usuario, UsuarioForm> {
	
	@Autowired
	private UsuarioHandle handle;

	@Override
	public Usuario prepararParaSalvar(UsuarioForm form, String id) {
		return handle.addOrUpdate(form, id);
	}

	@Override
	public void aposSalvar(Usuario entidade) {
		
	}

	@Override
	public IEntidadeDto toDto(Usuario entidade) {
		return new UsuarioDtoPadrao(entidade);
	}

}
