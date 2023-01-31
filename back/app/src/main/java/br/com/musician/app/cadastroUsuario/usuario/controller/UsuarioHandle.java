package br.com.musician.app.cadastroUsuario.usuario.controller;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.musician.app.aplicacao.Status;
import br.com.musician.app.aplicacao.interfaces.IDefaultCommandHandle;
import br.com.musician.app.cadastroUsuario.model.Perfil;
import br.com.musician.app.cadastroUsuario.model.Usuario;
import br.com.musician.app.cadastroUsuario.usuario.persistencia.UsuarioDao;

@Service
public class UsuarioHandle implements IDefaultCommandHandle<Usuario, UsuarioForm> {

	private UsuarioDao dao;

	@Autowired
	public UsuarioHandle(UsuarioDao dao) {
		this.dao = dao;
	}

	public Usuario add(UsuarioForm form) {
		Usuario usuario = new Usuario();
		preencherUsuario(form, usuario);
		usuario.setStatus(Status.PENDENTE);
		usuario.setPerfil(Perfil.CLIENTE);
		return usuario;
	}

	private void preencherUsuario(UsuarioForm form, Usuario usuario) {
		usuario.setLogin(form.getLogin().toLowerCase());
		usuario.setPassword(encode(form.getPassword()));
	}

	public Usuario update(UsuarioForm form, String id) {
		UsuarioFiltro filtro = new UsuarioFiltro();
		filtro.setId(id);
		Collection<Usuario> usuarios = dao.pesquisa(filtro);
		if (CollectionUtils.isEmpty(usuarios))
			throw new IllegalArgumentException("Usuario não localizado!");
		Usuario usuario = usuarios.iterator().next();
		preencherUsuario(form, usuario);
		return usuario;
	}

	private String encode(String senha) {
		if (senha == null)
			throw new IllegalArgumentException("Favor informa a senha!");
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		return bCrypt.encode(senha);
	}
}
