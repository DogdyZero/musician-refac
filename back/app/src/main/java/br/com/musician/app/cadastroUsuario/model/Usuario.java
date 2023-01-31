package br.com.musician.app.cadastroUsuario.model;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.stereotype.Component;

import br.com.musician.app.aplicacao.Status;
import br.com.musician.app.aplicacao.interfaces.IEntidade;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Component
public class Usuario implements IEntidade {

	@Id
	@GeneratedValue
	@UuidGenerator
	@Column(name = "usu_id")
	private UUID id;
	
	@Column(name = "usu_login")
	private String login;
	
	@Column(name = "usu_password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "usu_status")
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column(name = "usu_perfil")
	private Perfil perfil;

	@OneToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pessoa;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
