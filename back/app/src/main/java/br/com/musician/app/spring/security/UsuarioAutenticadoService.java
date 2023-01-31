package br.com.musician.app.spring.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.musician.app.cadastroUsuario.model.Usuario;
import br.com.musician.app.cadastroUsuario.usuario.persistencia.UsuarioRepository;

@Service
public class UsuarioAutenticadoService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByLogin(login);
		if (usuario.isPresent()) {
			return new UsuarioAutenticado(usuario.get());
		}
		
		throw new UsernameNotFoundException("Dados inválidos!");
	}

}
