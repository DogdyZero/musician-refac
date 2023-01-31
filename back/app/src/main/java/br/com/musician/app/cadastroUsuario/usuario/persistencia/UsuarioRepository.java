package br.com.musician.app.cadastroUsuario.usuario.persistencia;

import java.util.Optional;

import br.com.musician.app.aplicacao.interfaces.JpaGenericRepository;
import br.com.musician.app.cadastroUsuario.model.Usuario;

public interface UsuarioRepository extends JpaGenericRepository<Usuario>{
	Optional<Usuario> findByLogin(String login);
}
