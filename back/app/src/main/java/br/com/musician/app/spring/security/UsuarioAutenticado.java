package br.com.musician.app.spring.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.musician.app.aplicacao.Status;
import br.com.musician.app.cadastroUsuario.model.Usuario;

public class UsuarioAutenticado implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	public UsuarioAutenticado(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return usuario.getPassword();
	}

	@Override
	public String getUsername() {
		return usuario.getLogin();
	}

	public String getId() {
		return usuario.getId().toString();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return usuario.getStatus() != null && usuario.getStatus().equals(Status.ATIVO) ? true : false;
	}
}
