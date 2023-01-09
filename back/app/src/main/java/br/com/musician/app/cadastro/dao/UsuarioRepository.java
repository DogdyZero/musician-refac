package br.com.musician.app.cadastro.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musician.app.cadastro.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByLogin(String login);
}
